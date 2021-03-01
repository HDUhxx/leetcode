package com.atguigu.DP.区间;

public class NO486预测赢家
{
    /**
     *      dp?
     *      为什么要填表
     *      怎么填表？
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
    int[][] dp = new int[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++)
    {
        dp[i][i] = nums[i];
    }

    //状态转移方程 :
    for (int j = 1; j < nums.length; j++)
    {
        for (int i = j - 1; i >= 0 ; i--)
        {
            dp[i][j] = Math.max(nums[i] - dp[i + 1][j],nums[j] - dp[i][j - 1]);
        }
    }

    return dp[0][nums.length - 1] >= 0;

}

    /**
     *      递归
     * @param nums
     * @return
     */
    public boolean PredictTheWinner1(int[] nums) {
          int res = dfs(nums,0,nums.length - 1);

          return res >= 0;
    }

    private int dfs(int[] nums, int l, int r)
    {
        if (l > r) return 0;

        if (l == r) return nums[l];
        int i = dfs(nums,l + 1,r);
        int j = dfs(nums,l,r - 1);

        return Math.max(nums[l] - i,nums[r] - j);
    }
}
