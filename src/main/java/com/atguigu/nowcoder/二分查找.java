package com.atguigu.nowcoder;

public class 二分查找 {
    public int search (int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left)/2;
            if (nums[mid] == target){
                while (mid > 0 && nums[mid] == nums[mid - 1]){
                    mid--;
                }
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
