package com.atguigu.DP.股票;

public class MaxProfit2
{
    public static void main(String[] args)
    {

    }


    /**`NO.122
     *  股票问题的最大收益2：没有冷冻期
     *  *  三种状态 0：没有股票
*                  1：持有
*                  2：刚卖了
*         状态转移方程：
*                  0：前一天就没有/前一天刚卖
*                  1：前一天就持有     /前一天没有，今天刚买（要-price【i】）    /前一天刚卖，今天刚买
*                  2：今天卖出（要加上price【i】）
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < len; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][2] - prices[i],dp[i][1]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        return Math.max(dp[len - 1][2],dp[len - 1][0]);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }

        return dp[dp.length - 1][0];
    }
}
