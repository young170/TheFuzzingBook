#include "shellsort.h"

int *shellsort (int *elems, int length) {
    int *sorted_elems;
    sorted_elems = (int *) malloc(sizeof(int) * length);

    copy_elems(sorted_elems, elems, length);

    int gaps[8] = {701, 301, 132, 57, 23, 10, 4, 1};
    int gaps_length = sizeof(gaps) / sizeof(int);

    for (int i = 0; i < gaps_length; i++) {
        for (int j = gaps[i]; j < length; j ++) {
            int tmp = sorted_elems[j];
            int itr = j;

            while ((itr >= gaps[i])
                    && (sorted_elems[itr - gaps[i]] > tmp))  {
                sorted_elems[itr] = sorted_elems[itr - gaps[i]];
                itr -= gaps[i];
            }

            sorted_elems[itr] = tmp;
        }
    }

    return sorted_elems;
}

void copy_elems (int *destination, int *source, int length) {
    for (int i = 0; i < length; i++) {
        destination[i] = source[i];
    }
}

int is_sorted (int *elems, int length) {
    for (int i = 0; i < length - 1; i++) {
        if (elems[i] > elems[i + 1]) {
            return 0;
        }
    }

    return 1;
}

int is_permutation (int *a, int *b, int a_length, int b_length) {
    if (a_length != b_length) {
        return 0;
    }

// a
    int max = get_max(a, a_length);
    if (-1 == max) {
        return 0;
    }

    int *a_occurrence = (int *) malloc(sizeof(int) * max);
    a_occurrence = (int *) memset(a_occurrence, 0, sizeof(int) * max);

    increment_occurrence(a_occurrence, a, a_length);

// b
    max = get_max(b, b_length);
    if (-1 == max) {
        return 0;
    }

    int *b_occurrence = (int *) malloc(sizeof(int) * max);
    b_occurrence = (int *) memset(b_occurrence, 0, sizeof(int) * max);

    increment_occurrence(b_occurrence, b, b_length);

// common
    int res = check_identical(a_occurrence, b_occurrence, a_length);

    free(a_occurrence);
    free(b_occurrence);

    return res;
}

int check_identical (int *a, int *b, int length) {
    for (int i = 0; i < length; i++) {
        if (a[i] != b[i]) {
            return 0;
        }
    }
}

void increment_occurrence (int *destination, int *source, int length) {
    for (int i = 0; i < length; i++) {
        destination[source[i]]++;
    }
}

int get_max (int *arr, int length) {
    int max = -1;

    for (int i = 0; i < length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    return max;
}

void print_array (int *arr, int length) {
    for (int i = 0; i < length; i++) {
        printf("%d: %d\n", i, arr[i]);
    }
}