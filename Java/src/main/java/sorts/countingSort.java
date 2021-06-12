package sorts;

public class countingSort {
    public countingSort(int[] arr){
        sort(arr);
    }
    void sort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num: arr){
            max = Math.max(num, max);
        }
        int[] sorted = new int[max + 1];

        for(int num: arr){
            sorted[num]++;
        }
        for(int i = 1; i <= max; i++) {
            sorted[i] += sorted[i-1];
        }
        int[] output = new int[arr.length+1];
        for(int i = arr.length - 1; i >= 0; i--){
            output[sorted[arr[i]] - 1] = arr[i];
            sorted[arr[i]]--;
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
