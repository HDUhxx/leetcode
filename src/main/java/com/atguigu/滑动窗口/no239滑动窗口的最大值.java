package com.atguigu.滑动窗口;

import java.util.Arrays;

public class no239滑动窗口的最大值
{
    //未做
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        int left = 0,n = 0;

        for (int i = k - 1; i < nums.length; i++)
        {

            for (int j = left; j < k; j++)
            {
                ans[i] = nums[left];
                if (nums[j] > left){
                    ans[i] = nums[j];
                }
            }
            left ++;
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(ints));
    }
}
