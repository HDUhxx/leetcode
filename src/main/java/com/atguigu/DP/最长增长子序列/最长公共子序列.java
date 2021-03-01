package com.atguigu.DP.最长增长子序列;

public class 最长公共子序列
{

    /*输入：text1 = "abcde", text2 = "ace"
    输出：3
    解释：最长公共子序列是 "ace"，它的长度为 3。*/
    public static void main(String[] args)
    {
    }

    /**
     *     1143.最长公共子序列
     *     二维表格
     *     dp[i - 1][j - 1] dp[i - 1][j]
     *     dp[i][j - 1]     dp[i][j]
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int len1 = t1.length;
        int len2 = t2.length;

        if (len1 == 0 || len2 == 0){
            return 0;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++)
        {
            for (int j = 1; j < len2 + 1; j++)
            {
                if (t1[i - 1] == t2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
