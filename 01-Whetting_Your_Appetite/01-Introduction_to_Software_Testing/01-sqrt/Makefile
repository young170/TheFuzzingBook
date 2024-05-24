CC = gcc
SRC_DIR = src
INC_DIR = include
SRC = sqrt.c
INC = sqrt.h
TARGET = run

$(TARGET) : driver.c $(SRC_DIR)/$(SRC) $(INC_DIR)/$(INC)
	gcc -o $(TARGET) driver.c $(SRC_DIR)/$(SRC) -I./$(INC_DIR)

clean :
	rm -rf $(TARGET)
