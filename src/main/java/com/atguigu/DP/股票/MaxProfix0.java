package com.atguigu.DP.股票;

public class MaxProfix0
{

    /**
     *      股票问题只能买一次：
     *              dp[i] :代表前i天的最大收益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];//dp[i] :代表前i天的最大收益
        dp[0] = 0;
        int min = prices[0];
        for(int i = 1;i < len;i ++){
            if(prices[i] < min){
                min = prices[i];
            }
            dp[i] = Math.max(dp[i - 1],prices[i] - min);
        }
        return dp[len - 1];
    }
}
