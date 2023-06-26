#include "sqrt.h"

void my_sqrt_program(char *arg) {
    int x = atoi(arg); // 0 on error

    if (0 == x) {
        printf("Illegal Input\n");
    } else {
        // negative input - infinite loop guard
        if (x < 0) {
            printf("Illegal Input\n");
        } else {
            printf("The root of %d is: %f\n", x, my_sqrt(x));
        }
    }
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

void my_sqrt_checked (double x) {
    double root = my_sqrt(x);
    assertEquals(root * root, x);
}

void assertEquals (double x,double y) {
    assert(fabs(x-y) < EPSILON);
}

void start_clock (void) {
    start_timer = clock();
}

int end_clock (void) {
    end_timer = clock() - start_timer;
    int msec = end_timer * 1000 / CLOCKS_PER_SEC;

    return msec;
}