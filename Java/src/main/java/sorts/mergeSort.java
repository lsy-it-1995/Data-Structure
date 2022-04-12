package sorts;

public class mergeSort {
    public mergeSort(int[] arr, int start, int end){
        sort(arr, start, end);
    }
    void sort(int[] arr, int start, int end){
        if(start < end){
            int mid = start + (end - start)/2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++; k++;
            }else{
                temp[k] = arr[j];
                j++; k++;
            }
        }
        while(i <= mid){
            temp[k] = arr[i];
            i++; k++;
        }
        while(j <= end){
            temp[k] = arr[j];
            j++; k++;
        }
        for(i = start; i <= end; i++){
            arr[i] = temp[i-start];
        }
    }
}
