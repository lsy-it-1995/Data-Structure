#ifndef QUICK_SORT_H
#define QUICK_SORT_H

#include <iostream>
#include "common_function.h"

using namespace std;

template<typename T>
void temp_main_in_quick_sort(T a[], size_t n);

template<typename T>
unsigned int partition(T a[], int low, int high);

template<typename T>
void quicksort(T a[], int low, int high);


template<typename T>
void temp_main_in_quick_sort(T a[], size_t n)
{

    unsigned int high = n - 1;
    unsigned int low = 0;
    //    shuffle(a,n);
    //    cout<<"before: ";print_array_segment(a,0,n);
    //    cout<< verifystr(a,n)<<endl;
    quicksort(a, low, high);
    //    cout<<"after: ";print_array(a,n,verify(a,n));
    cout<< "VERIFY"<<verifystr(a,n)<<endl;

    //    int c[]={};
    //    copy_array(c,a,n);
    //    cout<<"copy array: ";print_array_segment(c,0,n);
    //    cout<< verifystr(c,n)<<endl;
    //    cout<<endl;
}
template<typename T>
unsigned int partition(T a[], int low, int high)
{
    int i = low - 1;

    for(int j = low; j < high; j++)
    {
        if(a[j] < a[high])
        {
            i++;
            swap_numbers(&a[i],&a[j]);
        }
    }
    //swap the last #
    swap_numbers(&a[i+1],&a[high]);
    return (i + 1);
}

template<typename T>
void quicksort(T a[], int low, int high)
{
    if(low < high)
    {
        int pivot = partition(a, low, high);
        //pivot (index) is in correct position.
        //call quicksort for pivot below correct position
        quicksort(a, low, pivot - 1);
        //call quicksort for pivot above correct position
        quicksort(a, pivot + 1, high);
    }
}

#endif // QUICK_SORT_H
