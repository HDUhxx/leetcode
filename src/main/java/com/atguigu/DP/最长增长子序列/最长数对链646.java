package com.atguigu.DP.最长增长子序列;

public class 最长数对链646
{
    public static void main(String[] args)
    {

        int[][] pairs = {{1,2},{2,3},{3,4}};
        int longestChain = findLongestChain(pairs);
        System.out.println(longestChain);
    }


    public static int findLongestChain(int[][] pairs) {
        if (pairs.length == 0){
            return 0;
        }
        int dp[] = new int[pairs.length];//dp[i]表示以pairs[i]结尾的最长数对链

        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++)
        {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }

        int res = 0;

        for(int d : dp){
            if (d > res){
                res = d;
            }
        }

        return res;
    }
}
