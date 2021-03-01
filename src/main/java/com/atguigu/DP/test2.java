package com.atguigu.DP;

public class test2
{
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length  + 1][amount + 1];
        for (int i = 0; i < coins.length; i++)
        {
            dp[i][0] = 0;
        }
        for (int i = 0; i < amount + 1; i++)
        {
            dp[0][i] = amount + 1;
        }

        for (int i = 1; i < coins.length + 1; i++)
        {
            for (int j = 1; j < amount + 1; j++)
            {
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - coins[i -1]] + 1);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length ][amount] > amount ? -1 : dp[coins.length ][amount];
    }

    //最后的石头
    public int lastStoneWeightII(int[] stones) {
        return 0;
    }

//    public int numDecodings(String s) {
//        char[] chars = s.toCharArray();
//        int[] dp = new int[s.length()];
//        if (chars[0] == '0') return 0;
//        dp[0] = 1;
//        for (int i = 1; i < s.length(); i++)
//        {
//            if (chars[i - 1] > '2' && chars[i] > 6) {
//                dp[i] =
//            }
//        }
//    }
}
