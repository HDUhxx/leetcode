package com.atguigu.note1_68;

public class 连续子数组的最大值42
{
    public static void main(String[] args)
    {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (dp[i - 1] < 0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max,dp[i]);

        }
        return max;

    }
}
