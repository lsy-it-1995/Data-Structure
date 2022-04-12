#ifndef MERGE_SORT_H
#define MERGE_SORT_H

#include <iostream>
#include "common_function.h"

using namespace std;

template<typename T>
void Merge_sort(T a[], int start, int end);

template<typename T>
void Merge(T a[],int start , int mid, int end);

template<typename T>
void temp_main_in_merge_sort(T a[], size_t n);

template<typename T>
void temp_main_in_merge_sort(T a[], size_t n)
{
//    shuffle(a,n);
//    cout<<"before: ";print_array_segment(a,0,n);
//    cout<< verifystr(a,n)<<endl;

    Merge_sort(a,0,n-1);
//    cout<<"after: ";print_array(a,n,verify(a,n));
    cout<< "VERIFY"<<verifystr(a,n)<<endl;

//    int c[]={};
//    copy_array(c,a,n);
//    cout<<"copy array: ";print_array_segment(c,0,n);
//    cout<< verifystr(c,n)<<endl;
//    cout<<endl;
}

template<typename T>
void Merge(T a[],int start , int mid, int end)
{
    int index1 = mid - start +1;
    int index2 = end-mid;

    //2 arrays
    int L[index1], R[index2];

    for(int i = 0;i<index1;i++)
        L[i] =a[start+i];
    for(int j = 0;j<index2;j++)
        R[j] = a[mid+1+j];

    int i =0,  j=0,  k= start;

    //merging now
    while(i<index1 && j<index2)
    {
        if(L[i]<=R[j])
        {
            a[k] = L[i];
            i++; //increment the L
        }
        else
        {
            a[k]=R[j];
            j++;//increment the R
        }
        k++;//increment the a
    }

    //left over in L
    while(i<index1)
    {
        a[k] = L[i];
        i++;
        k++;
    }
    //left over in R
    while(j<index2)
    {
        a[k] = R[j];
        j++;
        k++;
    }
}

//changing m only
template<typename T>
void Merge_sort(T a[], int start, int end)
{

    if(start<end)
    {
        int m;
        m = (end-start)/2 +start;
        Merge_sort(a,start,m);
        Merge_sort(a,m+1,end);
        Merge(a,start,m,end);
    }
}
#endif // MERGE_SORT_H
