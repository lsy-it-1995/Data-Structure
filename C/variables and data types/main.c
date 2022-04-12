#include <stdio.h>      

int main() {
    char c = 'a';
    short s = 12;
    int i = 342;
    long l = 1231432;
    float f = 123.54;
    double d = 23424.534254;
    printf("%f", f);
    printf("size of char is %d\n", sizeof(char));
    printf("size of short is %d\n", sizeof(short));
    printf("size of int is %d\n", sizeof(int));
    printf("size of float is %d\n", sizeof(float));
    printf("size of long is %d\n", sizeof(long));
    printf("size of double is %d\n", sizeof(double));
    return 0;
}