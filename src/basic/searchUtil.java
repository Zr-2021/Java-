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

    // 记录上一次冒泡时最后一次比较的索引，作为下一次比较次数
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

    public void selection(int[] nums){
        // i 代表每一轮选择最小元素需要交换到的目标索引
        for (int i = 0; i < nums.length-1; i++) {
            int s = i;
            for (int j = s+1; j < nums.length; j++) {
                if (nums[j]<nums[s]) s = j;
            }
            if (s != i) swap(nums, i, s);
        }
    }

    public void insert(int[] nums){
        // i 代表待插入元素的索引
        for (int i = 1; i < nums.length; i++) {
            // 记录待插入元素的值
            int num = nums[i];
            // 已排序的最后一个元素的索引
            int index = i-1;
            while (index>=0 && num<nums[index]){
                nums[index+1] = nums[index];
                index--;
            }
            nums[index+1] = num;
        }
    }

    public void quickSort(int[] nums){
        int low = 0;
        int high = nums.length-1;
        quick(nums, low, high);
    }

    private void quick(int[] nums, int low, int high) {
        if (low >= high) return;
//        int index = partition(nums, low, high);
        int index = partition2(nums, low, high);
        quick(nums, low, index-1);
        quick(nums, index+1, high);
    }

    private int partition2(int[] nums, int low, int high) {
        // 双边循环
        int pivot = nums[low];
        int i = low;
        int j = high;
        while (i<j){
            while (i<j && nums[j] > pivot){
                j--;
            }
            while (i<j && nums[i] <= pivot){
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private int partition(int[] nums, int low, int high) {
        // 单边循环
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
