CC = gcc

run : driver.c src/sqrt.c include/sqrt.h
	gcc -o run driver.c src/sqrt.c -I./include

clean :
	rm -rf run