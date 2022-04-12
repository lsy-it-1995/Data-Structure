#ifndef COMMON_FUNCTIONS_H
#define COMMON_FUNCTIONS_H

#include <iostream>
#include "../../../Documents/CS8(assignment)/Hash/timer.h"

using namespace std;

template<typename T>
void swap_numbers(T a, T b);

template<typename T>
void shuffle(T a[], int size);

template<typename T>
void copy_array(T dest[], const T src[], unsigned int size);

template<typename T>
bool verify(const T a[], unsigned int  size);

template<typename T>
string verifystr(const T a[], unsigned int  size);

template<typename T>
void print_array(const T a[], int size, bool status_only = false);

template<typename T>
void print_array_segment(T a[], int start, int end);

template<typename T>
void swap_numbers(T *a, T *b)
{
    T temp = *a;
    *a = *b;
    *b = temp;
}

//shuffle elements of a[]
template<typename T>
void shuffle(T a[], int size)
{
    for(int i = 0;i <size;i++)
        swap_numbers(&a[i],&a[rand()%size]);
}

template<typename T>
void copy_array(T dest[], const T src[], unsigned int size)
{
    for(unsigned int i = 0;i<size;i++)
    {
        dest[i]=src[i];
        cout<<"["<<dest[i]<<"]";
    }
}

//return true if a[] is in ascending order
template<typename T>
bool verify(const T a[], unsigned int  size)
{
    unsigned int success=0;
    for(unsigned int i = 0;i < size-2;i++)
    {
        if(a[i]<a[i+1])
            success++;
    }
    return (success==size-2)?true:false;
}

//return a string "SORTED" or "NOT SORTED" depending if a[] is sorted
template<typename T>
string verifystr(const T a[], unsigned int  size)
{
    string temp = "UNSORTED";
    if(verify(a,size))
    {
        temp = "SORTED";
        return temp;
    }
    else
        return temp;
}

//print the array if status_only is true along with info on sortedness of a[]
template<typename T>
void print_array(const T a[], int size, bool status_only)
{
    if(status_only)
    {
        for(int i =0;i<size;++i)
            cout<<"["<<a[i]<<"] ";
        cout<<endl;
    }
}


//print a[] from start to end
template<typename T>
void print_array_segment(T a[], int start, int end)
{
    for(T i = start;i<end;i++)
        cout<<"["<<a[i]<<"] ";
    cout<<endl;
}

#endif // COMMON_FUNCTIONS_H
