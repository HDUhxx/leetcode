package com.atguigu.DP.股票;

public class MaxProfit3
{

    public static void main(String[] args)
    {

    }

    /**
     *      股票问题的最大收益（只能进行两次交易）NO.123
     *      5个状态
     *      0：没有买卖
     *      1：第一次买
     *      2：第一次卖
     *      3：第二次买
     *      4：第二次卖
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[0][2] = 0;
        dp[0][3] = - prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < dp.length; i++)
        {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3],dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4],dp[i - 1][3] + prices[i]);
        }

        return Math.max(dp[dp.length - 1][2],dp[dp.length - 1][4]);
    }
}
