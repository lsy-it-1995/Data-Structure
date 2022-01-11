package sorts;

import java.util.Arrays;

public class quickSort {
    public quickSort(int[] arr, int low, int high){
        sort(arr, low, high);
    }
    public void sort(int[] arr, int low, int high){
        if(low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }
    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int index = low - 1;
        for(int i = low; i < high; i++){
            if(pivot >= arr[i]){
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, index + 1, high);
        return index + 1;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
