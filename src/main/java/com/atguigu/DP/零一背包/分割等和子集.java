package com.atguigu.DP.零一背包;

public class 分割等和子集
{
    public static void main(String[] args)
    {
        int[] nums = {1,5,11,5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int maxNum = 0;
        for(int i = 0;i < nums.length;i ++){
            maxNum = Math.max(maxNum,nums[i]);
            sum += nums[i];
        }
        int target = sum/2;
        if(sum%2 != 0){
            return false;
        }
        if(maxNum > target){
            return false;
        }

        boolean[][] dp = new boolean[nums.length][target + 1];

        for(int i = 0;i < nums.length;i ++){
            dp[i][0] = true;
        }

        for(int i = 1;i < nums.length;i ++)
            for(int j = 1;j < target + 1;j ++){
                if(j >= nums[i]){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        return dp[nums.length - 1][target];

    }
}
