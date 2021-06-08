package com.atguigu.DP;

import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = {5,7,2,7,3,3,5,3,0};
        Test3 test3 = new Test3();
        test3.maxProfit(4,arr);
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 0; i < k; i++) {
            dp[0][2 * i + 1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j%2 == 0){
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - 1] + prices[i]);
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - 1] - prices[i]);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = Math.max(res,dp[prices.length - 1][2 * i]);
        }
        return res;
    }

    public int maxProfit3(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][1] = - prices[0];
        dp[0][3] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3],dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4],dp[i - 1][3] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][2],dp[prices.length - 1][4]);
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i] - fee,dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);
        }
        return dp[prices.length  - 1][0];
    }

    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][1] = -prices[0];
        //今天结束时的状态
        //0:不持股票，且当天没有卖出  1：持有股票 2：不持股，且卖出
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][1],dp[prices.length - 1][2]);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j*j] + 1,dp[i]);
            }
        }
        return dp[n];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j > 0; j--) {
                for (int k = n; k > 0; k--) {
                    int[] arr = getOneAndZero(strs[i]);
                    if (arr[0] <= j && arr[1] <= k){
                        dp[j][k] = Math.max(dp[j][k],dp[j - arr[0]][k - arr[1]] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    private int[] getOneAndZero(String str) {
        if (str.length() == 0) return new int[]{0,0};
        int zero = 0,one = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0'){
                zero ++;
            }else if (str.charAt(i) == '1'){
                one ++;
            }
        }
        return new int[]{zero,one};
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (String str : wordDict){
                if (i >= str.length() && s.substring(i - str.length(),i).equals(str)){
                    dp[i] = dp[i] || dp[i - str.length()];
                }
            }
        }
        return dp[s.length()];
    }

    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                res = Math.max(res,dp[i + 1][j + 1]);
            }
        }
        return res;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars = text1.toCharArray();
        char[] chars1 = text2.toCharArray();
        int[][] dp = new int[chars.length + 1][chars1.length + 1];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars1.length; j++) {
                if (chars[i] == chars1[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1],dp[i + 1][j]);
                }
            }
        }
        return dp[chars.length][chars1.length];
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        int sum = 0,max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        if (sum % 2 != 0) return false;
        if (max > sum/2) return false;

        int target = sum/2;
        boolean[] dp = new boolean[target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]){
                    dp[j] = dp[j - nums[i]] || dp[j];
                }
            }
        }
        return dp[target];
    }


    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - coins[i]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]){
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
