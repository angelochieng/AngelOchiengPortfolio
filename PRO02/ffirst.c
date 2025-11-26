#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "vec.h"
#include <float.h>

 static double calc_cost_sq(double* data, int n, int dim, int* c, int m, int* arg_max) {
    double cost_sq = 0;
    *arg_max = 0;  

    for (int i = 0; i < n; i++) {
        double min_dist_sq = DBL_MAX;
        for (int j = 0; j < m; j++) {
            double dist_sq = vec_dist_sq(&data[i*dim],&data[c[j]*dim],dim);
            if (dist_sq < min_dist_sq) {
                    min_dist_sq = dist_sq;
            }
        }
    if (min_dist_sq > cost_sq) {
        cost_sq = min_dist_sq;
        *arg_max = i;
        }
    }
    return cost_sq;
 }

int main (int argc, char** argv) {
    if (argc < 2) {
        printf ("command usage: %s %s\n",argv[0],"blank");
        return 1;
    }
    int k = atoi(argv[1]);
    int len, dim;
    if (scanf("%d %d",&len,&dim) != 2) {
        printf ("error reading the length and dimension of the dataset\n");
        return 1;
    }
    double* data = (double*)malloc(len*dim*sizeof(double));
    if (data == NULL) {
        printf ("malloc failed to allocate data matrix\n");
        return 1;
    }
    vec_read_dataset (data,len,dim);
    int* c = (int*)malloc(k * sizeof(int));
    if (c == NULL) {
        printf("malloc failed to allocate centers array\n");
        free(data);
        return 1;
    }
    c[0] = 0;
    
    for (int m = 1; m < k; m++) {
        int next_center;
        double cost_sq = calc_cost_sq(data, len, dim, c, m, &next_center);
        c[m] = next_center;
    }
    int k_cent;
    double final_cost_sq = calc_cost_sq(data, len, dim, c, k, &k_cent);
    double final_cost = sqrt(final_cost_sq);
    
    
    printf("approximate optimal cost = %.4f\n", final_cost);
    printf("approximate optimal centers:");
    for (int i = 0; i < k; i++) {
        printf(" %d", c[i]);
    }
    printf("\n");
    free(data);
    return 0;
}