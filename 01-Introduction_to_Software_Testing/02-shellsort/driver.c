#include "shellsort.h"

int main (int argc, char *argv[]) {
    printf("Driver: shellsort\n");

// Basic Setup
    int elems[3] = {3, 2, 1};

    int *sorted = shellsort(elems, 3);

    print_array(sorted, 3);
    free(sorted);

// Manual Test Cases
    int arr[3] = {1, 1, 2};
    int length = sizeof(arr) / sizeof(int);

    sorted = shellsort(arr, length);

    assert(sorted[0] <= sorted[length - 1]);

    print_array(sorted, 3);

// Random Inputs
    int res = is_sorted(arr, length);

    if (res == 0) {
        printf("False\n");
    } else {
        printf("True\n");
    }

    int a[3] = {3, 2, 1};
    int b[3] = {1, 3, 2};

    res = is_permutation(a, b, (sizeof(a) / sizeof(int)), (sizeof(b) / sizeof(int)));

    if (res == 0) {
        printf("False\n");
    } else {
        printf("True\n");
    }

// End of Program
    free(sorted);

    return 0;
}