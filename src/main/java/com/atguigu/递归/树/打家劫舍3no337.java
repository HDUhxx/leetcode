package com.atguigu.递归.树;

public class 打家劫舍3no337
{

//    public static void main(String[] args)
//    {
//        Integer[] tree = {3,2,3,null,3,null,1};
//        TreeNode treeNode = TreeNode.constructTree(tree);
//        int rob = rob(treeNode);
//        System.out.println(rob);
//    }
    public  int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    //dp:多加一个维度，消除后效性
    private  int[] dfs(TreeNode root)
    {
        if (root == null) return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] dp = new int[2];
        dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        dp[1] = root.val + left[0] + right[0];

        return dp;
    }

    /*public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++)
        {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1],dp[i -1]);
        }
        return dp[nums.length];
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        //dp[i][o]:表示以nums[i]结尾的最小值
        //dp[i][1]:表示以nums[i]结尾的最大值
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > 0){
                dp[i][0] = Math.min(dp[i - 1][0] * nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1] * nums[i],nums[i]);
            }else {
                dp[i][0] = Math.min(dp[i - 1][1] * nums[i] ,nums[i]);
                dp[i][1] = Math.max(dp[i - 1][0] * nums[i],nums[i]);
            }
        }

        int max = nums[0];
        for (int i = 0; i < dp.length; i++)
        {
            if (dp[i][1] > max){
                max = dp[i][1];
            }
        }

        return max;

    }*/
}
