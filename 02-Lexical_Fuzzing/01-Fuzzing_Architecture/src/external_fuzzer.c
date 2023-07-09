#include "../include/external_fuzzer.h"

FILE_INFO *create_temp_dir() {
    char *tempdir_name = "tmp.XXXXXX"; 
    char *tempdir = mkdtemp(tempdir_name); 

    if(tempdir == NULL) {
        perror("mkdtemp failed"); 
        return NULL; 
    }

    FILE_INFO *file_info = (FILE_INFO *) malloc(sizeof(FILE_INFO));

    file_info->dir_name = (char *) malloc(sizeof(char) * (strlen(tempdir) + 1));
    strcpy(file_info->dir_name, tempdir);
    
    return file_info;
}