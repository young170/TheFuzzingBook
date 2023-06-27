#include "quad.h"

int main (int argc, char *argv[]) {
    printf("Driver: quad\n");

// Basic
    double *solver = quadratic_solver(3, 4, 1);

    printf("%f, %f\n", solver[0], solver[1]);

// Bug-triggering inputs
    solver = quadratic_solver(3, 4, 1);
    // division by zero
    printf("%f, %f\n", solver[0], solver[1]);

// Fix the problems

// Odds and Ends
    // 32-bit integers
    // found a bug where a and b are zero
    // p = 1 / (2^32 * 2^32)
    double combinations = pow(2, 32) * pow(2, 32);
    printf("combinations: %f\n", combinations);

    double tests_per_sec = 1000000000;
    double sec_per_yr = 60 * 60 * 24 * 365;
    double tests_per_yr = tests_per_sec * sec_per_yr;

    printf("%f\n", (combinations / tests_per_yr));

// End of Program
    free(solver);

    return 0;
}