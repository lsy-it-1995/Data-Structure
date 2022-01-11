package sorts;

public class bubbleSort {
    public bubbleSort(int[] nums){
        sort(nums);
    }
    //i  j
    //29,10,5,37,14
    public void sort(int[] nums){
      for(int i = nums.length - 1; i >= 0; i--){
          for(int j = 0; j < i; j++){
              if(nums[j] >= nums[i]){
                  swap(nums, i, j);
              }
          }
      }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
