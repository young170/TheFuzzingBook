#include "shellsort.h"

int *shellsort(int *elems, int length) {
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

void copy_elems(int *destination, int *source, int length) {
    for (int i = 0; i < length; i++) {
        destination[i] = source[i];
    }
}

void print_array (int *arr, int length) {
    for (int i = 0; i < length; i++) {
        printf("%d: %d\n", i, arr[i]);
    }
}