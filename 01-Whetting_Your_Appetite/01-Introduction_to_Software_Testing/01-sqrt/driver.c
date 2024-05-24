#include "sqrt.h"

int main (int argc, char *argv[]) {
    printf("Driver: sqrt\n");

// Automating Test Execution
    double result = my_sqrt(4);
    double expected_result = 2.0;

    // brute-check
    if (result == expected_result) {
        printf("Test passed\n");
    } else {
        printf("Test failed\n");
    }

    // assertion
    assert(2 == my_sqrt(4));
    assert(abs((int) my_sqrt(4) - 2) < EPSILON);

// Generating Tests
    assertEquals(my_sqrt(2) * my_sqrt(2), 2);

    // loop generation
    for (int i = 1; i < 1000; i++) {
        assertEquals((my_sqrt((double) i) * my_sqrt((double) i)), (double) i);
    }

    // measure elapsed time
    start_clock();

        for (int i = 0; i < 10000; i++) {
            assertEquals(my_sqrt((double) i) * my_sqrt((double) i), (double) i);
        }

    int msec = end_clock();
    printf("Elapsed time: %d\n", (msec / 1000));

    // random values
    srand(time(NULL));
    start_clock();

        for (int i = 0; i < 10000; i++) {
            double x = 1 + rand() % 1000000;
            assertEquals(my_sqrt(x) * my_sqrt(x), x);
        }

    msec = end_clock();
    printf("Elapsed time: %d\n", (msec / 1000));

// Run-Time Verification
    my_sqrt_checked(2.0);

// Causing Errors
    my_sqrt_program("-1"); // infinite loop
    my_sqrt_program("xyzzy"); // invalid literal
    my_sqrt_program("0"); // divide by zero
    
    // my_sqrt(INFINITY); // infinity

// End of Program
    return 0;
}