#include "shellsort.h"

int main (int argc, char *argv[]) {
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
    
}