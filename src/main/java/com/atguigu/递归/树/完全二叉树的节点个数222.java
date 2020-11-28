package com.atguigu.递归.树;

public class 完全二叉树的节点个数222
{
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }

        int l = countNodes(root.left);
        int r = countNodes(root.right);

        return l + r + 1;
    }
}
