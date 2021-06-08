package com.atguigu.note1_68;

public class no68_1
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }

        return root;
    }
}
