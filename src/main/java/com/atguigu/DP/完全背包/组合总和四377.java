package com.atguigu.DP.完全背包;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和四377
{

    /**
     *      给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     *      nums = [1, 2, 3]
     * target = 4
     *
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * @param args
     */
    public static void main(String[] args)
    {

    }

    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0){
            return 1;
        }

        List<Integer> path  = new ArrayList<>();
        dfs(nums,target,path,res);
        return res.size();
    }

    private void dfs(int[] nums, int target, List<Integer> path, List<List<Integer>> res)
    {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0){
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] <= target){
                path.add(nums[i]);
                dfs(nums,target - nums[i],path,res);
                path.remove(path.size() - 1);
            }
        }
    }

    public int combinationSum41(int[] nums, int target) {
        int[] dp = new int[target];
        dp[0] = 1;

        for (int i = 0; i < target + 1; i++)
        {
            for (int num : nums){
                if (num <= i){
                    dp[i] = dp[i - num] + dp[i];
                }
            }
        }
        return dp[target];




















        /*int[] dp = new int[target + 1];
        dp[0] = 1;
        //自底向上，先求出组成1-i的所有种类，
        for (int i = 1; i < target + 1; i++)
        {
            for(int num : nums){
                if (i >= num){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];*/
    }
}
