package com.atguigu.递归.树;



public class 二叉搜索树第k大节点剑指54
{
    int res;
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }

    private void dfs(TreeNode root, int k)
    {
        if (root == null){
            return;
        }



        dfs(root.right, k);
        if (--k == 0){
            res = root.val;
            return;
        }
        dfs(root.left, k);
    }


}
