#include <stdio.h>
#include <stdlib.h>
#include <float.h>
#include <omp.h>
#include "vec.h"

/* calculate the arg max */
int calc_arg_max(double* data, int num_points, int dim, int* centers, int m) {
    int arg_max = 0;
    double cost_sq = 0;  

    #pragma omp parallel default(none) shared(data, num_points, dim, centers, m, arg_max, cost_sq)
    {
        int thread_arg_max = 0;
        double thread_cost_sq = 0;

        #pragma omp for
        for (int i = 0; i < num_points; i++) {
            double min_dist_sq = DBL_MAX;
            for (int j = 0; j < m; j++) {
                double dist_sq = vec_dist_sq(data + i * dim, data + centers[j] * dim, dim);
                if (dist_sq < min_dist_sq) {
                    min_dist_sq = dist_sq;
                }
            }

            if (min_dist_sq > thread_cost_sq) {
                thread_cost_sq = min_dist_sq;
                thread_arg_max = i;
            }
        }

        #pragma omp critical
        {
            if (thread_cost_sq > cost_sq) {
                cost_sq = thread_cost_sq;
                arg_max = thread_arg_max;
            }
        }
    }

    return arg_max;
}


/* find the index of the cluster for the given point */
int find_cluster (double* kmeans, double* point, int k, int dim) {

    int cluster;
    double min_dist_sq = DBL_MAX;
    for (int i=0;i<k;i++) {
        double dist_sq = vec_dist_sq(kmeans+i*dim,point,dim);
        if (dist_sq < min_dist_sq) {
            min_dist_sq = dist_sq;
            cluster = i;
        }
    }
    return cluster;
}

/* calculate the next kmeans */
void calc_kmeans_next(double* data, int num_points, int dim,
                      double* kmeans, double* kmeans_next, int k) {

    int cluster_size[k];
    for (int i = 0; i < k; i++) {
        cluster_size[i] = 0;
    }
    vec_zero(kmeans_next, k * dim);

    #pragma omp parallel default(none) shared(data, num_points, dim, kmeans, kmeans_next, k, cluster_size)
    {
        int thread_cluster_size[k];
        double thread_kmeans_next[k * dim];

        
        for (int i = 0; i < k; i++) {
            thread_cluster_size[i] = 0;
        }
        vec_zero(thread_kmeans_next, k * dim);  

        #pragma omp for
        for (int i = 0; i < num_points; i++) {
            int cluster = find_cluster(kmeans, data + i * dim, k, dim);
            double* thread_kmean = thread_kmeans_next + cluster * dim;
            vec_add(thread_kmean, data + i * dim, thread_kmean, dim);
            thread_cluster_size[cluster] += 1;
        }

        
        #pragma omp critical
        {
            for (int i = 0; i < k; i++) {
                if (thread_cluster_size[i] > 0) {
                    double* global_kmean = kmeans_next + i * dim;
                    vec_add(global_kmean, thread_kmeans_next + i * dim, global_kmean, dim);
                    cluster_size[i] += thread_cluster_size[i];
                }
            }
        }
    } 
    for (int i = 0; i < k; i++) {
        double* kmean = kmeans_next + i * dim;
        if (cluster_size[i] > 0) {
            vec_scalar_mult(kmean, 1.0 / cluster_size[i], kmean, dim);
        } else {
            printf("error : cluster has no points!\n");
            exit(1);
        }
    }
}


/* calculate kmeans using m steps of Lloyd's algorithm */
void calc_kmeans (double* data, int num_points, int dim, double* kmeans, int k, int num_iter) {

    /* find k centers using the farthest first algorithm */
    int centers[k];
    centers[0] = 0;
    for (int m=1;m<k;m++) {
        centers[m] = calc_arg_max(data,num_points,dim,centers,m);
    }

    /* initialize kmeans using the k centers */
    for (int i=0;i<k;i++) {
        vec_copy(kmeans+i*dim,data+centers[i]*dim,dim);
    }

    /* update kmeans num_iter times */
    double kmeans_next[k*dim];
    for (int i=0;i<num_iter;i++) {
        calc_kmeans_next(data,num_points,dim,kmeans,kmeans_next,k);
        vec_copy(kmeans,kmeans_next,k*dim);
    }
}

int main (int argc, char** argv) {

    /* get k, m, and thread_count from command line */
    if (argc < 4) {
        printf ("Command usage : %s %s %s %s\n",argv[0],"k","num_iter","thread_count");
        return 1;
    }
    int k = atoi(argv[1]);
    int num_iter = atoi(argv[2]);
    int thread_count = atoi(argv[3]);
    omp_set_num_threads(thread_count);

    /* read the shape of the data matrix */
    int num_points, dim;
    if (scanf("%*c %d %d",&num_points, &dim) != 2) {
        printf ("error reading the shape of the data matrix\n");
        return 1;
    }

    /* dynamically allocate memory for the data array */
    double* data = (double*)malloc(num_points*dim*sizeof(double));

    /* Read vectors from stdin and store them in the data array */
    for (int i=0;i<num_points;i++) {
        if (vec_read_stdin(data+i*dim,dim) != dim) {
            printf ("error reading the next point from stdin\n");
            return 1;
        }
    }

    /* start the timer */
    double start_time, end_time;
    start_time = omp_get_wtime();

    /* calculate kmeans using m steps of Lloyd's algorithm */
    double kmeans[k*dim];
    calc_kmeans(data,num_points,dim,kmeans,k,num_iter);

    /* stop the timer */
    end_time = omp_get_wtime();

#ifdef TIMING
    printf ("(%d,%.4f),",thread_count,(end_time-start_time));
#else
    /* print out the thread count */
    printf ("# thread_count = %d\n",thread_count);

    /* print out wall time used */
    printf ("# wall time used = %g sec\n",end_time-start_time);

    /* print the results */
    for (int i=0;i<k;i++) {
        for (int j=0;j<dim;j++) {
            printf ("%.5lf ",kmeans[i*dim+j]);
        }
        printf ("\n");
    }
#endif

    /* free the dynamically allocated memory */
    free (data);
}
