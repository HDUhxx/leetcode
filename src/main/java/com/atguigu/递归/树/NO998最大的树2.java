package com.atguigu.递归.树;

public class NO998最大的树2 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }

        TreeNode node = insertIntoMaxTree(root.right, val);
        root.right = node;
        return root;
    }
}
