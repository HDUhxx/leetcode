package com.atguigu.DP;

import com.sun.xml.internal.bind.v2.model.core.ID;
import sun.misc.FpUtils;
import sun.security.util.Length;

import java.nio.channels.Pipe;
import java.util.*;

public class test1
{

    //零钱兑换2
//    public int change(int amount, int[] coins) {
//        int len = coins.length;
//        int[] dp = new int[amount + 1];
//        dp[0] = 1;
//        for (int i = 0; i < len; i++)
//        {
//            for (int j = 0; j < amount + 1; j++)
//            {
//                dp[j] += dp[j - coins[i]];
//            }
//        }
//    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++)
        {
            for (int num : nums){
                if (i > num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);

        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++)
        {
            for (int j = 0; j < coins.length; j++)
            {
                if (i >= coins[i]) {
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        int[][] dp = new int[len][2 * sum + 1];
        if (nums[0] == 0) {
            dp[0][nums[0]] = 2;
        }else {
            dp[0][nums[0]] = 1;
            dp[0][nums[1]] = 1;
        }

        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < 2 * sum + 1; j++)
            {
                int l = j - nums[i] >= 0 ? j - nums[i] : 0;
                int r = j + nums[i] < 2 * sum + 1 ? j + nums[i] : 0;

                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }

        return dp[len - 1][sum + S];

    }


    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
        {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++)
            {
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp =  new int[m + 1][n + 1];
        for (String str : strs) {
            int[] cut = count(str);
            for (int i = m;i - cut[0] >= 0 ;i--)
            {
                for (int j = n; j - cut[1] >= 0 ; j--)
                {
                    dp[i][j] = Math.max(dp[i][j],dp[i - cut[0]][j - cut[1]]);
                }
            }
        }

        return dp[m][n];
    }

    private int[] count(String s){
        int[] res = new int[2];
        for (char c : s.toCharArray()) {
            res[c - '0'] ++;
        }
        return res;
    }
}
