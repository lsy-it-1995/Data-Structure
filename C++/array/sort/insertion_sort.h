#ifndef INSERTION_SORT_H
#define INSERTION_SORT_H

#include <iostream>
#include "common_function.h"

using namespace std;

template<typename T>
void insert_sort(T a[],int n);

template<typename T>
void temp_main_in_insertion_sort(T a[], size_t n);

template<typename T>
void temp_main_in_insertion_sort(T a[], size_t n)
{

//    shuffle(a,n);
//    cout<<"before: ";print_array_segment(a,0,n);
//    cout<< verifystr(a,n)<<endl;

    insert_sort(a,n);
//    cout<<"after: ";print_array(a,n,verify(a,n));
    cout<< "VERIFY"<<verifystr(a,n)<<endl;

//    int c[]={};
//    copy_array(c,a,n);
//    cout<<"copy array: ";print_array_segment(c,0,n);
//    cout<< verifystr(c,n)<<endl;
//    cout<<endl;
}

template<typename T>
void insert_sort(T a[],int n)
{
    size_t size = sizeof(a)/sizeof(a[0]);
    shuffle(a,size);
    int j;
    for(int i = 0;i<n;i++)
    {
        j = i;
        while(a[j]<a[j-1]&&j>0)
        {
            swap_numbers(&a[j],&a[j-1]);
            j--;
        }
    }
}

#endif // INSERTION_SORT_H
