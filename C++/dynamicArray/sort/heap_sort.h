#ifndef HEAP_SORT_H
#define HEAP_SORT_H
#include <iostream>
#include "../../../Documents/CS8(assignment)/Heapclass/heap.h"
#include "common_function.h"

using namespace std;

template<typename T>
void temp_main_in_heap_sort(T a[], size_t n);

template<typename T>
void temp_main_in_heap_sort(T a[], size_t n)
{

    Heap<int> heap;
//    shuffle(a,n);
    //    cout<<"before: ";print_array_segment(a,0,n);
    //    cout<< verifystr(a,n)<<endl;
    for(size_t i=0;i<n;i++)
        heap.insert(a[i]);
    for(int i =n-1;i==0;i--)
    {
        a[i]=heap.Pop();
    }
    //    cout<<heap<<endl;

}

#endif // HEAP_SORT_H
