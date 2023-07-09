#include "../include/simple_fuzzer.h"

char *fuzzer (int max_length, int char_start, int char_range) {
    srand(time(0x0));

    int string_length = rand() % (max_length) + 1;
    char *out = (char *) malloc(sizeof(char) * (string_length + 1));

    for (int i = 0; i < string_length; i++) {
        out[i] = (char) rand() % (char_range) + char_start;
    }

    out[string_length] = '\0';

    return out;
}