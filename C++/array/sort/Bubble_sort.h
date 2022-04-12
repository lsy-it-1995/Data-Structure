#ifndef B_S_H
#define B_S_H

#include <iostream>
#include "common_function.h"

using namespace std;

template<typename T>
void bubble_sort(T a[], int b);

template<typename T>
void temp_main_in_bubble_sort(T a[], size_t n);

template<typename T>
void temp_main_in_bubble_sort(T a[], size_t n)
{
//    shuffle(a,n);
//    cout<<"before: ";print_array_segment(a,0,n);
//    cout<< verifystr(a,n)<<endl;

    bubble_sort(a,n);
//    cout<<"after: ";print_array(a,n,verify(a,n));
    cout<< "VERIFY"<<verifystr(a,n)<<endl;

//    int c[]={};
//    copy_array(c,a,n);
//    cout<<"copy array: ";print_array_segment(c,0,n);
//    cout<< verifystr(c,n)<<endl;
//    cout<<endl;
}

template<typename T>
void bubble_sort(T a[], int b)
{
    for(int i= 0; i < b-1;i++)
    {
        for(int j = 0; j<b-1;j++)
        {
            if(a[j]>a[j+1])
                swap_numbers(&a[j],&a[j+1]);
        }
    }
}
#endif // B_S_H
