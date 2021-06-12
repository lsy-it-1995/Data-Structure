package sorts;

public class heapSort {
    public heapSort(int[] arr){
        sort(arr);
    }
    void sort(int[] arr){
        int n = arr.length;
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }
        for(int i = n - 1; i >= 0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    void heapify(int[] arr, int n, int i){
        int largest = i,
                l = 2 * i + 1,
                r = 2 * i + 2;
        if(l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if(r < n && arr[r] > arr[largest]){
            largest = r;
        }
        if(largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
