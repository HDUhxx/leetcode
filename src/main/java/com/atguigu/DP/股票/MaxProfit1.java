package com.atguigu.DP.股票;

import java.util.Arrays;
import java.util.Comparator;

public class MaxProfit1
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,4};
        int i = maxProfit(arr);
        System.out.println(i);
        int[][] nums = new int[3][4];

    }


    /** NO.309
     *  股票问题的最大收益(含冻结期，可以进行多次)：     dp[i][j]:表示在j状态下的前i天的最大收益
     *          三种状态 0：不持股票，且没有卖出
     *                  1：持有
     *                  2：不持有股票，且刚卖了
     *         状态转移方程：
     *                  0：前一天就没有/前一天刚卖
     *                  1：前一天就持有/今天刚买（要-price【i】）
     *                  2：今天卖出（要加上price【i】）
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        int len = prices.length;
        if(len == 0){
            return 0;
        }
        int[][] dp= new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < len; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][2]);//前一天就没有，前一天刚卖出
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);//前一天就持有，今天刚买
            dp[i][2] = dp[i - 1][1] + prices[i];//今天刚卖
        }

        return Math.max(dp[len - 1][0],dp[len - 1][2]);
    }
}
