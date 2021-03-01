package com.atguigu.note1_68;

public class 丑数49
{
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int two = 0,three = 0,five = 0;

        for (int i = 1; i < n; i++)
        {
            dp[i] = Math.min(dp[two] * 2,Math.min(dp[three] * 3,dp[five] * 5));
            if (dp[i] == dp[two] * 2){
                two ++;
            }else if (dp[i] == dp[three] * 3){
                three ++;
            }else {
                five ++;
            }
        }

        return dp[n];
    }
}
