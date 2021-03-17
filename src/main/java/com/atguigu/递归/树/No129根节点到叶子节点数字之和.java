package com.atguigu.递归.树;

public class No129根节点到叶子节点数字之和 {

    private int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null)return;
        int k = val * 10 + root.val;
        if (root.left == null && root.right == null){
            sum += k;
            return;
        }

        dfs(root.left,k);
        dfs(root.right,k);
    }
}
