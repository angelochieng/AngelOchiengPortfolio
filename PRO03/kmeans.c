#include <stdio.h>
#include <stdlib.h>
#include <float.h>
#include "vec.h"
#include "farfirst.h"

int find_cluster (double* kmeans, double* point, int k, int dim) {
    int cluster = 0;
    double min_dist = DBL_MAX;
    for (int j = 0; j < k; j++){
        double distance = vec_dist_sq(kmeans + j * dim, point, dim);
        if (distance < min_dist) {
            min_dist = distance;
            cluster = j;
        }
      
    }
    return cluster;
}

// calculate the next kmeans
void calc_kmeans_next (double* data, int num_points, int dim, double* kmeans, double* kmeans_next, int k) {
    double cluster_sums[k * dim];
    int cluster_nums[k];
    for (int j = 0; j < k; j++){
        vec_zero(cluster_sums + j * dim, dim);
        cluster_nums[j] = 0;

    }
    for (int i = 0; i< num_points; i++){
        double* point = data + i * dim;
        int clusters = find_cluster(kmeans, point, k , dim);
        vec_add(cluster_sums + clusters * dim, point, cluster_sums + clusters * dim, dim);
        cluster_nums[clusters] ++;
        
    }
    for (int j = 0; j < k; j++){
        if (cluster_nums[j] == 0) {
        printf ("Error empty cluster\n");
        exit(1);
        }
        vec_scalar_mult(cluster_sums + j * dim, 1.0 / cluster_nums[j], kmeans_next + j * dim, dim);    
    }
}

// calculate kmeans using m steps of Lloyd's algorithm
void calc_kmeans (double* data, int num_points, int dim, double* kmeans, int k, int m) {

    // find k centers using the farthest first algorithm
    int centers[k];
    farfirst(data,num_points,dim,centers,k);

    // initialize kmeans using the k centers
    for (int i=0;i<k;i++) {
        vec_copy(kmeans+i*dim,data+centers[i]*dim,dim);
    }

    // update kmeans m times
    double kmeans_next[k*dim];
    for (int i=0;i<m;i++) {
        calc_kmeans_next(data,num_points,dim,kmeans,kmeans_next,k);
        vec_copy(kmeans,kmeans_next,k*dim);
    }
}
