package sorts;

import java.util.Arrays;

public class quickSort {
    public quickSort(int[] arr, int low, int high){
        sort(arr, low, high);
    }
    int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int index = (low - 1);
        for(int i = low; i < high; i++){
            if(pivot >= arr[i]){
                index++;
                System.out.println(i);
                swap(arr, index, i);
            }
        }
        swap(arr, index + 1, high);
        System.out.println(Arrays.toString(arr));
        return index + 1;
    }
    void sort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
