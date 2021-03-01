package com.atguigu.递归.树;

import java.util.Arrays;

public class test1
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root;

    }

    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        int k = 0;
        if (nums[0] != nums[1]) res[k++] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]){
                res[k++] = nums[i];
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) res[k ++] = nums[nums.length - 1];

        return res;
    }

    class node1{
        public node1(boolean isbalan, int depth) {
            this.isbalan = isbalan;
            this.depth = depth;
        }

        boolean isbalan;
        int depth;

    }

    public boolean isBalanced(TreeNode root) {
        return isBa(root).isbalan;
    }

    private node1 isBa(TreeNode root){
        if (root == null){
            return new node1(true,0);
        }

        node1 left = isBa(root.left);
        node1 right = isBa(root.right);
        if (!left.isbalan || !right.isbalan){
            return new node1(false,0);
        }

        boolean res = Math.abs(left.depth - right.depth) <= 1;
        if (!res) return new node1(false,0);
        int depth = Math.max(left.depth,right.depth);
        return new node1(true,depth);
    }


    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right) + 1;
    }



        int res,k ;
    public int kthLargest(TreeNode root, int k) {

        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }



        dfs(root.right);
        if (k == 0) return;

        if (--k == 0){
            res = root.val;
            return;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        Integer[] arr = {3,1,4,null,2};
        TreeNode node = TreeNode.constructTree(arr);
        test1 t1 = new test1();
        int i = t1.kthLargest(node, 1);
        System.out.println(i);
    }
}


