package sorts;

public class cocktailSort {
    public cocktailSort(int[] arr){
        sort(arr);
    }
    public void sort(int[] arr){
        int min_pivot = 0,
                max_pivot = arr.length - 1;
        boolean swap = true;

        while(swap == true){
            swap = false;
            for(int i = min_pivot; i < max_pivot; i++){
                if(arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1);
                    swap = true;
                }
            }
            if(swap == false){
                break;
            }
            swap = false;
            max_pivot--;

            for(int i = max_pivot; i > min_pivot; i--){
                if(arr[i] < arr[i - 1]){
                    swap(arr, i, i - 1);
                    swap = true;
                }
            }

            min_pivot ++;
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
