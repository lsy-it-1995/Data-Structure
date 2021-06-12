package sorts;

public class introSort {
    public introSort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }
    public static void sort(int[] arr, int begin, int end){
        double maxdepth = Math.floor(Math.log(Double.valueOf(arr.length))) * 2.0;
        introSort(arr, begin, end - 1, (int)maxdepth);
    }

    public static int medianOfThree(int[] arr, int l, int m, int h){
        int a = arr[l], b = arr[m], c = arr[h];
        // a < b < c
        if(a < b && b < c){
            return m;
        }
        // a < c < b
        if(a < c && c < b){
            return h;
        }
        // b < a < c
        if(b < a && a < c){
            return l;
        }
        // b < c  < a
        if(b < c && c < a){
            return h;
        }
        // c < a < b
        if(c < a && a < b){
            return l;
        }
        // c < b < a
        return m;

    }
    public static void introSort(int[] arr, int begin, int end, int depth){
        int left = arr[begin],
                right = arr[end];

        int size = end - begin;
        if(size < 16){
            quickSort qs_arr = new quickSort(arr, begin, end - 1);
            return;
        }
        if(depth == 0){
            heapSort hp = new heapSort(arr);
            return;
        }
        int mid = arr[end - begin];
        int pivot = medianOfThree(arr, left, mid, right);
        introSort(arr, left, pivot, depth - 1);
        introSort(arr, pivot + 1, end, depth - 1);
    }}
