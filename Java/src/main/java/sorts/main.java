package sorts;

import java.util.Arrays;

public class main {
    public static void main(String[] args){
        int[] arr = {29,10,5,37,14};
        System.out.println("Original: " + Arrays.toString(arr));

        mergeSort ms = new mergeSort(arr, 0, arr.length - 1);

        System.out.println("After sorted: " + Arrays.toString(arr));
    }
}
//       selectionSort sr = new selectionSort(arr);
//        bubbleSort bs = new bubbleSort(arr);
//        countingSort cs = new countingSort(arr);

//        insertionSort is = new insertionSort(arr);

//        heapSort hs = new heapSort(arr);

//        quickSort qs = new quickSort(arr, 0, arr.length - 1);