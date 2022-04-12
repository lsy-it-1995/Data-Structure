#include <iostream>
#include "Bubble_sort.h"
#include "insertion_sort.h"
#include "quick_sort.h"
#include "heap_sort.h"
#include <ctime>
#include "merge_sort.h"
#include <iomanip>

using namespace std;


float time_sort_routine(int a[], unsigned int  size, void (*f)(int *, unsigned int));
int main()
{
    srand(time(NULL));

    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(10);
    int max_size = 50000;

//        int a[max_size] ={};

    int *a = new(nothrow) int[max_size];

    int n = sizeof(a)/sizeof(a[0]);
    for(int i = 0;i<max_size;i++)
    {
        a[i]=(rand()%max_size+1);
    }
//    int *aa = new(nothrow) int[max_size];
//    int *aaa = new(nothrow) int[max_size];
//    int *aaaa = new(nothrow) int[max_size];
//    int *aaaaa = new(nothrow) int[max_size];

//    int aa[max_size] ={};
//    int aaa[max_size] ={};
//    int aaaa[max_size] ={};
//    int aaaaa[max_size] ={};

    shuffle(a,max_size);

//    copy_array(aa,a,n);
//    copy_array(aaa,a,n);
//    copy_array(aaaa,a,n);
//    copy_array(aaaaa,a,n);

    bool    BUBBLE_S = true,
            INSERT_S = false,
            HEAP_S = false,
            QUICK_S = false,
            MERGE_S = false;
    float   total_bubble_s = 0,
            total_insert_s=0,
            total_heap_s = 0,
            total_quick_s =0,
            total_merge_s =0;

    int loops = 100;

    for(int i =0;i<loops;i++)
    {
        if(BUBBLE_S)
            total_bubble_s+=time_sort_routine(a,n,temp_main_in_bubble_sort);
//        if(INSERT_S)
//            total_insert_s+=time_sort_routine(aa,n,temp_main_in_insertion_sort);
//        if(HEAP_S)
//            total_heap_s+=time_sort_routine(aaa,n,temp_main_in_heap_sort);
//        if(QUICK_S)
//            total_quick_s+=time_sort_routine(aaaa,n,temp_main_in_quick_sort);
//        if(MERGE_S)
//            total_merge_s+=time_sort_routine(aaaaa,n,temp_main_in_merge_sort);
    }
//    delete[] aa;
//    delete[] aaa;
//    delete[] aaaa;
//    delete[] aaaaa;

    if(BUBBLE_S)
        cout<<"AVERAGE DURATION IN BUBBLE SORT: "<<total_bubble_s/loops<<endl;
    if(INSERT_S)
        cout<<"AVERAGE DURATION IN INSERTION SORT: "<<total_insert_s/loops<<endl;
    if(HEAP_S)
        cout<<"AVERAGE DURATION IN HEAP SORT: "<<total_heap_s/loops<<endl;
    if(QUICK_S)
        cout<<"AVERAGE DURATION IN QUICK SORT: "<<total_quick_s/loops<<endl;
    if(MERGE_S)
        cout<<"AVERAGE DURATION IN MERGE SORT: "<<total_merge_s/loops<<endl;
    delete[] a;

    cout << "Hello World!" << endl;
    return 0;
}

float time_sort_routine(int a[], unsigned int  size, void (*f)(int *, unsigned int)){
    timer t;
    t.start();
    f(a, size);
    t.stop();
    return t.duration();
}
