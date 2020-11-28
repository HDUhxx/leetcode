package com.atguigu.math;

public class 丑数3
{
    public static void main(String[] args)
    {
        int i = nthUglyNumber(4,2,3,4);
        System.out.println(i);
    }
    public static int nthUglyNumber(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        int a1 = 0,b1 = 0,c1 = 0;
        for(int i = 1;i < n + 1;i ++){
            int t1 = dp[a1] + a,t2 = dp[b1] + b,t3 = dp[c1] + c;
            dp[i] = Math.min(Math.min(t1,t2),t3);
            if(dp[i] == t1){
                a1++;
            }
            if(dp[i] == t2){
                b1 ++;
            }
            if(dp[i] == t3){
                c1 ++;
            }
        }

        return dp[n];
    }
}
