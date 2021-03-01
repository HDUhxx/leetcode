package com.atguigu.递归.树;

public class 剑指26数的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B)
    {
        if (A == null || B == null)
        {
            return false;
        }

        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode a, TreeNode b)
    {
        if (b == null)
        {
            return true;
        }
        if (a == null || a.val != b.val)
        {
            return false;
        }

        return isSub(a.left, b.left) && isSub(a.right, b.right);
    }
}
