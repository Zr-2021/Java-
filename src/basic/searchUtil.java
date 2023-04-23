package basic;

/**
 * @author zr
 * @date 2023/4/23
 */

public class searchUtil {
    int[] nums = {1,2,3,4,5,6,7,8,9,10};
    int[] sortNums = {4,5,7,2,9,0,8,3,1};

    public boolean binarySearch(int num, int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right - left)/2;
//            移位求中间索引
//            int mid = (right + left) >>>1;
            if (nums[mid]==num) return true;
            else if (nums[mid]>num){
                right = mid-1;
            }
            else left = mid+1;
        }
        return false;
    }
    public boolean binarySearch(int n){
        return binarySearch(n, nums);
    }

    public void bubble(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            boolean swapped = false; //记录是否发生了交换
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j]>nums[j+1]){
                    swap(nums, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    //记录上一次冒泡时最后一次比较的索引，作为下一次比较次数
    public void bubble2(int[] nums){
        int n = nums.length-1;
        while(n>0) {
            int lastIndex = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i]>nums[i+1]){
                    swap(nums, i, i+1);
                    lastIndex = i;
                }
            }
            n = lastIndex;
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
