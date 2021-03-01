package com.atguigu.math;

import java.util.*;

public class 丑数2第n个丑数
{
    public static int nthUglyNumber(int n) {
         int[] dp = new int[n];
         dp[0] = 1;
         int two = 0,three = 0,five = 0;
        for (int i = 1; i < n; i++)
        {
            dp[i] = Math.min(dp[two] * 2,Math.min(dp[three] * 3,dp[five] * 5));
            if (dp[i] == dp[two] * 2){
                two++;
            }
            if (dp[i] == dp[three] * 3){
                three ++;
            }
            if (dp[i] == dp[five] * 5){
                five ++;
            }

        }

        return dp[n - 1];
    }

    public static void main(String[] args)
    {

        int i = nthUglyNumber(10);
        System.out.println(i);
    }
}
