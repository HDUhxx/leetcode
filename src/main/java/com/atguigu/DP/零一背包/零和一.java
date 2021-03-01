package com.atguigu.DP.零一背包;

public class 零和一
{
    public static void main(String[] args)
    {
        String[] s = {"10","0001","111001","1","0"};
        int m = 5, n = 3;
        int i = findMaxForm(s, m, n);
        System.out.println(i);
    }

    /**
     *      strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int [strs.length + 1][m + 1][n + 1];
        for(int i = 1;i < strs.length + 1;i ++){
            int[] count = count(strs[i - 1]);

            for(int j = 0;j < m + 1;j ++){
                for (int k = 0; k < n + 1; k++)
                {
                    if (count[0] > j || count[1] > k){
                        dp[i][j][k] = dp[i - 1][j][k];
                    }else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],dp[i - 1][j - count[0]][k - count[1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public static int[] count(String s){
        int[] res = new int[2];
        for(char c : s.toCharArray()){
            if (c == '0'){
                res[0] ++;
            }else {
                res[1] ++;
            }
        }
        return res;
    }
}
