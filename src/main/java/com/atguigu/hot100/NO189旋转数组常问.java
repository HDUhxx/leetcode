package com.atguigu.hot100;

public class NO189旋转数组常问 {


    public void rotate(int[] nums, int k) {
        k %= nums.length;
        myReverse(nums,0,nums.length - 1);
        myReverse(nums,0,k - 1);
        myReverse(nums,k,nums.length - 1);
    }

    private void myReverse(int[] nums, int left, int right) {
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }
}
