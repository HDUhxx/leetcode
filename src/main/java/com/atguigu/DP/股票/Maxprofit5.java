package com.atguigu.DP.股票;

public class Maxprofit5
{

    /**
     *      股票问题最大收益（含有手续费）
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices,int fee) {
        if (prices.length < 2)return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);
        }

        return Math.max(dp[dp.length - 1][0],dp[dp.length - 1][1]);
    }
}
