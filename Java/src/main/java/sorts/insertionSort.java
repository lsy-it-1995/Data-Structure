package sorts;

public class insertionSort {
    public insertionSort(int[] arr){
        sort(arr);
    }
    void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i - 1, key = arr[i];
            while(j >= 0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
