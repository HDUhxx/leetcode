package com.atguigu.DP;

public class 强盗3 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null){
            return new int[]{};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = left[0] + right[0];
        return res;
    }
}
