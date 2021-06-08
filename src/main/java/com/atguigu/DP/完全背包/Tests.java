package com.atguigu.DP.完全背包;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
    }

    /**
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     *
     * 思路：首先判断的是某个coin使用了几次？
     * 所以先遍历coins
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]){
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     *  输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     *
     * 思路： 首先判断，某个coin用了几次？
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    /**
     *  输入：nums = [1,2,3], target = 4
     * 输出：7
     * 解释：
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     *  思路：1 + dp[3] ; 2 + dp[2] 3 + dp[1];
     *  不同的顺序，先要求出组成target的种类
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[i]){
                    dp[i] += dp[i - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
