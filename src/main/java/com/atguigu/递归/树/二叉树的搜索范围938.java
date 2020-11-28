package com.atguigu.递归.树;

public class 二叉树的搜索范围938
{

    int ans;
    public int rangeSumBST(TreeNode root, int low, int high) {


        //dfs
        ans = 0;
        dfs(root,low,high);
        return ans;











        //递归
//        if (root == null){
//            return 0;
//        }
//
//
//
//        if (root.val < low){
//            return rangeSumBST(root.right,low,high);
//        }
//        if (root.val > high){
//            return rangeSumBST(root.left,low,high);
//        }
//
//        return root.val + rangeSumBST(root.left,low,high) +rangeSumBST(root.right,low,high);
    }

    public void dfs(TreeNode root, int low, int high)
    {
        if (root != null){
            if (root.val >= low && root.val <= high){
                ans += root.val;
            }
            if (root.val < high){
                dfs(root.right,low,high);
            }
            if (root.val > low){
                dfs(root.left,low,high);
            }
        }
    }
}
