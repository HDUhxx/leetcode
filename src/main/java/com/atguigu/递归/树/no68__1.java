package com.atguigu.递归.树;

import lombok.val;

public class no68__1
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        /*if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if (root.val >p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        return root;*/

        //终止条件
        if (root == null || root == p || root == q){
            return root;
        }

        //左、右边搜索
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //左边没有公共节点，返回右边搜索的结果
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }

        //左右都没有搜索到，返回根节点
        return root;
    }
}
