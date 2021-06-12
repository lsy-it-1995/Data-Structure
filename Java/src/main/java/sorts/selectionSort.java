package sorts;

public class selectionSort {
    public selectionSort(int[] arr){
        sort(arr);
    }
    void sort(int[] arr){
        for(int i = 0; i + 1 < arr.length; i++){
            int min_index = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[min_index] > arr[j]){
                    min_index = j;
                }
            }
            swap(arr, i, min_index);
        }
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
