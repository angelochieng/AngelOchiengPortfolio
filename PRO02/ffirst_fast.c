#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "vec.h"
#include <float.h>

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
    double* min_dist_sq = (double*)malloc(len*sizeof(double));
    if (min_dist_sq == NULL) {
        printf ("malloc failed to allocate data matrix\n");
        return 1;
    }
    c[0] = 0;
    double max_dist_sq = 0;
    int next_center = 0;
    for (int i = 0; i< len; i++) {
        min_dist_sq[i] = vec_dist_sq(&data[i*dim],&data[0],dim);
        if (min_dist_sq[i] > max_dist_sq) {
                max_dist_sq = min_dist_sq[i];
                next_center = i;
            }
    }
    if (k > 1) {
        c[1] = next_center;
    }
    for (int m = 2; m < k; m++) {
        double total_dist_sq = 0;
        next_center = 0;
        for (int i = 0; i < len; i++) {
            double dist_new = vec_dist_sq(&data[i*dim],&data[c[m-1]*dim],dim);
            if (dist_new < min_dist_sq[i]) {
                    min_dist_sq[i] = dist_new;
            }
            if (min_dist_sq[i] > total_dist_sq) {
                total_dist_sq = min_dist_sq[i];
                next_center = i;
            }
        }
        c[m] = next_center;
    }
    
    
    free(data);
    return 0;
}