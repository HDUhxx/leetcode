package com.atguigu.DP;

import com.sun.xml.internal.bind.v2.model.core.ID;
import sun.misc.FpUtils;
import sun.security.util.Length;

import java.nio.channels.Pipe;
import java.util.*;

public class test1 {


    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs){
            int[] zeroAndOne = get(s);
            for (int i = m; i >= zeroAndOne[0]; i--) {
                for (int j = n; j >= zeroAndOne[1] ; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - zeroAndOne[0]][j - zeroAndOne[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private int[] get(String s ){
        if (s.length() < 1) return new int[]{0,0};
        int zero = 0,one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                zero ++;
            }else if (s.charAt(i) == '1'){
                one ++;
            }
        }
        return new int[]{zero,one};
    }


    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) return false;
            if (nums[i] == target) return true;
        }

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0 ; j--) {
                if (j >= nums[i]){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }


        public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        int maxLen = 0;
        for (String str : wordDict){
            if (str.length() > maxLen){
                maxLen = str.length();
            }
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = i > maxLen ? i - maxLen : 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }


        public int numSquares(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        int count = 0;
        while (!q.isEmpty()){
            count ++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                for (int j = (int) Math.sqrt(poll); j >= 1 ; j--) {
                    if (poll - j * j == 0) return count;
                    q.add(poll - j * j);
                }
            }
        }
        return n;
    }



    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 || obstacleGrid[0].length < 1 ||obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1){
                dp[i][0] = dp[i - 1][0];
                                    }else {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != 1){
                dp[0][i] = dp[0][i - 1];
            }else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];

    }


    public int minPathSum(int[][] grid) {
         if (grid.length == 0 || grid[0].length == 0 ) return 0;
         int[][] dp = new int[grid.length][grid[0].length];
         dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }


    public int uniquePaths(int m, int n) {
        if (m < 2 || n < 2) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) return 0;
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = 1;//dp[i]表示以i结尾，最长的上升序列
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[ j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > res) res = dp[i];
        }
        return res;
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                up = down + 1;
            }else if (nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }

        return Math.max(up,down);
    }

    public boolean PredictTheWinner(int[] nums) {
        int res = dfs(nums,0,nums.length - 1);
        return res >= 0;
    }

    private int dfs(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int l = dfs(nums,left + 1,right);
        int r = dfs(nums,left,right - 1);
        return Math.max(nums[left] - l,nums[right] - r);
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (amount >= coins[i]){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }


        public int combinationSum4(int[] nums, int target) {
//        if (target == 0) return 1;
//
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (target >= nums[i]){
//                res += combinationSum4(nums,target - nums[i]);
//            }
//        }
//        return res;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target + 1; i++) {
            for(int num : nums){
                if (i >= num){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];


    }



    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < amount + 1; i++) {
            dp[0][i] = amount + 1;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i - 1]){
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - coins[i]] + 1);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }
}
