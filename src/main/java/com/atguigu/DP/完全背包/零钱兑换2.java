package com.atguigu.DP.完全背包;


/**
 *
 *      no.518
 *    最多多少种组合
 */
public class 零钱兑换2
{
    public static void main(String[] args)
    {

    }

    /**
     *      零钱兑换1
     * @param amount
     * @param coins
     * @return
     */
    public int change1(int amount, int[] coins) {
        int [][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i < amount + 1; i++)
        {
            dp[0][i] = 0;
        }
        for (int i = 1; i < coins.length + 1; i++)
        {
            dp[i][0] = 0;
        }
        for (int i = 1; i < coins.length + 1; i++)
        {
            for (int j = 1; j < amount + 1; j++)
            {
                if (j - coins[i] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - coins[i]] + 1);
                }
            }
        }
        return dp[coins.length][amount];
    }

    /**
     * 第 39 题问的是所有的组合列表，应该使用 回溯算法 求解；
     * 第 518 题问的是组合有多少种，而不是问具体的解。应该使用 动态规划 求解。
     *
     *      组合有多少种
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            // 从 coins[i] 开始即可
            for (int j = coins[i] ; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    /**
     *      dp[i][j]:   1、初始化：
     *                  2、状态转移：dp[i][j]=
     *                          可以放下coins[i-1]时：装＋不装
     *                          不可以时，只能选择不装
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int [][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 1; i < amount + 1; i++)
        {
            dp[0][i] = 0;
        }
        for (int i = 0; i < coins.length + 1; i++)
        {
            dp[i][0] = 1;
        }

        //一行一行填写
        for (int i = 1; i < coins.length + 1; i++)
        {
            for (int j = 1; j < amount + 1; j++)
            {
                if (j - coins[i - 1] >= 0){
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
