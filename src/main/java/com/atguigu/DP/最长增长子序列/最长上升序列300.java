package com.atguigu.DP.最长增长子序列;

public class 最长上升序列300
{
    public static void main(String[] args)
    {

    }


    /**
     *      dp[i]:必须把nums[i]放到最后一个，表示最后一个是nums[i]的最长值
     *              所以最后求出来的dp[n-1]并不一定是最长的
     * @param nums
     * @return
     */
    public int longest(int[] nums){
        if (nums.length == 1){
            return 1;
        }
        if (nums.length == 0 ){
            return 0;
        }

        int[] dp = new int[nums.length];

        dp[0] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }


        int res = 0;
        for (int d : dp){
            if (d > res){
                res = d;
            }
        }

        return res;
    }











































    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        int [] dp = new  int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++)
        {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++)
        {
            if (dp[i] > res){
                res = dp[i];
            }
        }
        return res;

    }
}
