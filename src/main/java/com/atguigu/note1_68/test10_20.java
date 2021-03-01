package com.atguigu.note1_68;

public class test10_20
{
    //NO.10
    public int fib(int n) {
        if (n == 0){
            return 0;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++)
        {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n -1];
    }

    //NO.10.2
    public int numWays(int n) {
        if (n == 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++)
        {
            dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;
        }
        return dp[n];
    }
}
