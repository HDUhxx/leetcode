package com.atguigu.note1_68;

public class 调整奇数在前21
{
    public int[] exchange(int[] nums) {
        if (nums.length < 2){
            return nums;
        }

        int left = 0,right = nums.length - 1;

        while (left < right){
            while (left < right && (nums[left] & 1) == 1){
                left ++;
            }
            while (left < right && (nums[right] & 1) == 0){
                right --;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        return nums;
    }
}
