#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

int main(int argc, char** argv) {

    /* get N and thread_count from command line */
    if (argc < 3) {
        printf ("Command usage : %s %s %s\n",argv[0],"N","thread_count");
        return 1;
    }
    long long N = atol(argv[1]);
    int thread_count = atoi(argv[2]);
    omp_set_num_threads(thread_count);

    /* start the timer */
    double start_time, end_time;
    start_time = omp_get_wtime();

    /* calculate the thread sums in parallel */
    long long thread_sums[thread_count];

#pragma omp parallel default(none) shared(N,thread_sums)
    {
        int thread_num = omp_get_thread_num();
        thread_sums[thread_num] = 0;
#pragma omp for
        for (long long i = 1; i <= N;i++) {
            thread_sums[thread_num] += i;
        }
    }

    /* add the results of the thread_sums */
    long long sum = 0;
    for (int i=0;i<thread_count;i++) {
        sum += thread_sums[i];
    }    

    /* stop the timer */
    end_time = omp_get_wtime();

    /* print results */
    printf ("thread_count = %d, ",thread_count);
    printf ("elapsed time = %g\n",end_time-start_time);
    printf (" N = %llu, ",N);
    printf ("sum = %llu, ",sum);
    printf ("N*(N+1)/2 = %llu\n",(N/2)*(N+1));

}
