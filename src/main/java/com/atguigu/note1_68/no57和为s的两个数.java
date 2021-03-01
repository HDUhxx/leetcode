package com.atguigu.note1_68;

public class no57和为s的两个数
{
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int sum = Integer.MAX_VALUE;
        while (sum != target){
            sum = nums[left] + nums[right];
            if (sum > target){
                right--;
            }else {
                left ++;
            }
        }

        int[] res = {nums[left],nums[right]};
        return res;
    }
}
