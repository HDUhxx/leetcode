package com.atguigu.DP.最长增长子序列;

public class No718最长重复子数组 {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m == 0 || n == 0) return 0;

        int res = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                /* 最长子数组必须是连续的，dp[i][j]表示的是以（i，j）结尾的最长的子数组
                                        如果相等的话，dp[i][j] = dp[i - 1][j - 1] + 1;
                                        不相等的话，  dp[i][j] = 0;
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }*/
                res = Math.max(dp[i][j],res);
            }
        }
        return res;
    }
}
