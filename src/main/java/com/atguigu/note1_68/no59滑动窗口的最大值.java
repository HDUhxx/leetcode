package com.atguigu.note1_68;

public class no59滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0,j = k - 1;
        int max = 0;
        for (int l = 0; l < k; l++) {
            max = Math.max(max,nums[l]);
        }

        int[] res = new int[nums.length - k + 1];
        int m = 0;
        for (int l = 0; l < nums.length - k + 1; l++) {
            res[m++] = max;
            i ++;
            j ++;
//            max = Math.max(max,Math.max(nums[i]))
        }
        return res;
    }
}
