package com.atguigu.递归.树;



public class 二叉搜索树第k大节点剑指54
{
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root)
    {
        if (root == null){
            return;
        }



        dfs(root.right);
        if (--k == 0){
            res = root.val;
            return;
        }
        dfs(root.left);
    }


}
