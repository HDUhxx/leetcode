package com.atguigu.Tencent;

public class NO230二叉树中第k小的元素 {

    /**
     * 中序遍历，第k次就是结果
     */
    int count ,res;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left,k);
        ++ count;
        if (count == k) {
            res = root.val;
        }
        inorder(root.right,k);
    }
}
