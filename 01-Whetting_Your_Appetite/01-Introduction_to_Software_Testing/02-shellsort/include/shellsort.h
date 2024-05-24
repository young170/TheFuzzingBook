#ifndef SHELLSORT_H
#define SHELLSORT_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

int *shellsort (int *elems, int length);
void copy_elems (int *destination, int *source, int length);
void print_array (int *arr, int length);
int is_sorted (int *elems, int length);
int is_permutation (int *a, int *b, int a_length, int b_length);
int get_max (int *arr, int length);
void increment_occurrence (int *destination, int *source, int length);
int check_identical (int *a, int *b, int length);

#endif /* shellsort.h */