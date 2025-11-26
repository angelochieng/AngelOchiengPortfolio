#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "vec.h"
#include <float.h>

static double ffirst_fast(double* data, int n, int dim, int k, int start, int* c) {
    double* min_dist_sq = (double*)malloc(n * sizeof(double));
    if (min_dist_sq == NULL) {
        printf ("malloc failed to allocate data matrix\n");
        return DBL_MAX;
    }
    c[0] = start;
    double max_dist_sq = 0;
    int next_center = 0;
    for (int i = 0; i < n; i++) {
        min_dist_sq[i] = vec_dist_sq(&data[i*dim], &data[start*dim], dim);
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
        for (int i = 0; i < n; i++) {
            double dist_new = vec_dist_sq(&data[i*dim], &data[c[m-1]*dim], dim);
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
    
    double final_cost_sq = 0;
    for (int i = 0; i < n; i++) {
        if (min_dist_sq[i] > final_cost_sq) {
            final_cost_sq = min_dist_sq[i];
        }
    }
    
    free(min_dist_sq);
    return sqrt(final_cost_sq);
}

int main (int argc, char** argv) {
    if (argc < 2) {
        printf ("command usage: %s %s\n", argv[0], "k");
        return 1;
    }
    int k = atoi(argv[1]);
    int len, dim;
    if (scanf("%d %d", &len, &dim) != 2) {
        printf ("error reading the length and dimension of the dataset\n");
        return 1;
    }
    double* data = (double*)malloc(len * dim * sizeof(double));
    if (data == NULL) {
        printf ("malloc failed to allocate data matrix\n");
        return 1;
    }
    vec_read_dataset (data, len, dim);
    int* best_c = (int*)malloc(k * sizeof(int));
    int* current_c = (int*)malloc(k * sizeof(int));
    if (best_c == NULL || current_c == NULL) {
        printf("malloc failed to allocate centers array\n");
        free(data);
        return 1;
    }
    
    double best_cost = DBL_MAX;
    for (int start = 0; start < len; start++) {
        double cost = ffirst_fast(data, len, dim, k, start, current_c);
        if (cost < best_cost) {
            best_cost = cost;
            for (int i = 0; i < k; i++) {
                best_c[i] = current_c[i];
            }
        }
    }
    
    printf("approximate minimal cost = %.4f\n", best_cost);
    printf("approximate optimal centers:");
    for (int i = 0; i < k; i++) {
        printf(" %d", best_c[i]);
    }
    printf("\n");
    
    free(data);
    return 0;
}