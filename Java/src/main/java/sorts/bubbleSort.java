package sorts;

public class bubbleSort {
    public bubbleSort(int[] arr){
        sort(arr);
    }
    void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i , j);
                }
            }
        }
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
