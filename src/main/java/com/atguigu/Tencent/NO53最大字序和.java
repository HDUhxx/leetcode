package com.atguigu.Tencent;

public class NO53最大字序和 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] < 0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (res < dp[i]) res = dp[i];
        }

        return res;
    }
}
