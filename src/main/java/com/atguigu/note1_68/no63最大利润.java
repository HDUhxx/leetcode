package com.atguigu.note1_68;

public class no63最大利润 {

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE,profit = 0;
        for (int i = 0; i < prices.length; i++) {
            cost = Math.min(cost,prices[i]);
            profit = Math.max(profit,prices[i] - cost);
        }

        return profit;
    }

}
