#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

int *shellsort (int *elems, int length);
void copy_elems (int *destination, int *source, int length);
void print_array (int *arr, int length);