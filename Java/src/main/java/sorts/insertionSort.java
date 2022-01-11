package sorts;

public class insertionSort {
    public insertionSort(int[] arr){
        sort(arr);
    }
    void sort(int[] arr){
       for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
       }
    }
    /*
   j      k
    29,10,5,5,14
    29,29,5,37,14
    10,29,5,37,14
    10,29,29,37,14
    10,10,29,37,14
    5,10,29,37,14
    */

}