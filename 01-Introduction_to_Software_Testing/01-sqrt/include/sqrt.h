#ifndef SQRT_H
#define SQRT_H

#include <stdio.h>
#include <assert.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>

#define EPSILON 1e-8

void my_sqrt_program(char *arg);
double my_sqrt (double x);
void my_sqrt_checked (double x);
void assertEquals (double x, double y);
void start_clock (void);
int end_clock (void);

clock_t start_timer;
clock_t end_timer;

#endif /* SQRT_H */