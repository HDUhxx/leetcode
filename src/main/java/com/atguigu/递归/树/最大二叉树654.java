package com.atguigu.递归.树;

public class 最大二叉树654
{
    //再想想，重写一遍
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length);
    }

    private TreeNode construct(int[] nums, int l, int r)
    {
        if (l == r){
            return null;
        }
        int max_i = max_i(nums, l, r);
        TreeNode root = new TreeNode( nums[max_i]);
        root.left = construct(nums,l,max_i);
        root.right = construct(nums,max_i + 1,r);

        return root;

    }

    private int max_i(int[] nums, int l, int r)
    {
        int max_i = l;
        for (int i = l; i < r; i++)
        {
            if (nums[max_i] < nums[i]){
                max_i = i;
            }
        }

        return max_i;
    }


}
