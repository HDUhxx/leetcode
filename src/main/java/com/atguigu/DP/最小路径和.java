package com.atguigu.DP;

public class 最小路径和
{

         /* [1,3,1],
            [1,5,1],
            [4,2,1]         左上到右下的最小距离*/
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1;i < grid.length;i ++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1;i < grid[0].length;i ++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for(int i = 1;i < grid.length;i ++){
            for(int j = 1;j < grid[0].length;j ++){
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j],dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[grid.length - 1][dp[0].length - 1];
    }
}
