package com.atguigu.DP.零一背包;

public class no494目标和
{
    /**
     *  输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     * 解释：
     *
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        int[][] dp = new int[len][sum * 2 + 1];
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j < sum * 2 + 1; j++)
            {
                //边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < sum * 2 + 1 ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }

        return dp[len - 1][S + sum];

    }
}



















