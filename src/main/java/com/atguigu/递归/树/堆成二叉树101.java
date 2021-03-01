package com.atguigu.递归.树;

public class 堆成二叉树101
{
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }



    private boolean check(TreeNode p, TreeNode q)
    {
        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        return check(p.left,q.right) && check(p.right,q.left) && p.val == q.val;
    } 


}
