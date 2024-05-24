#include "quad.h"
#include "sqrt.h"

double my_sqrt (double x);

double *quadratic_solver (double a, double b, double c) {
    double *solution = (double *) malloc(sizeof(double) * 2);

    if (0 == a || 0 == b) {
        solution[0] = 0;
        solution[1] = 0;

        return solution;
    }

    double q = (b * b) - (4 * a * c);
    
    assert(0 <= q);

    solution[0] = (-b + my_sqrt(q)) / (2 * a);
    solution[1] = (-b - my_sqrt(q)) / (2 * a);

    return solution;
}

double my_sqrt (double x) {
	double approx = 0;
	double guess = x / 2;

    while (approx != guess) {
        approx = guess;
        guess = (approx + x / approx) / 2;
    }

    return approx;
}