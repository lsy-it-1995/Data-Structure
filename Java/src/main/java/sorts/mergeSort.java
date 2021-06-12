package sorts;

public class mergeSort {
    public mergeSort(int[] arr, int start, int end){
        sort(arr, start, end);
    }
    void sort(int[] arr, int start, int end){
        if(start < end){
            int mid =  start + (end - start)/2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    void merge(int[] arr, int start, int mid, int end){
        int leftN = mid - start + 1,
                rightN = end - mid;
        int[] left = new int[leftN],
                right = new int[rightN];

        for(int i = 0; i < leftN; i++){
            left[i] = arr[i+start];
        }
        for(int i = 0; i < rightN; i++){
            right[i] = arr[mid + i + 1];
        }

        int i = 0, j = 0, k = start;
        while(i < leftN && j < rightN){
            if(left[i] <= right[j]){
                arr[start] = left[i++];
            }else{
                arr[start] = right[j++];
            }
            start++;
        }
        while(i<leftN){
            arr[start++] = left[i++];
        }
        while(j<rightN){
            arr[start++] = right[j++];
        }
    }
}
