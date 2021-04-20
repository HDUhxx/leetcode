package com.atguigu.递归.树;

public class NO124 {

    int ret = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getmax(root);
        return ret;
    }

    private int getmax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0,getmax(root.left));
        int right = Math.max(0,getmax(root.right));

        ret = Math.max(ret,root.val + left + right);
        return Math.max(left,right) + root.val;
    }
}
