package com.atguigu.note1_68;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class no55平衡二叉树
{
//    class ReturnNode{
//        boolean isBa;
//        int depth;
//
//        public ReturnNode(boolean isBa, int depth)
//        {
//            this.isBa = isBa;
//            this.depth = depth;
//        }
//    }
//    public boolean isBalanced(TreeNode root) {
//        return isBa(root).isBa;
//    }
//
//    private ReturnNode isBa(TreeNode root)
//    {
//        if (root == null){
//            return new ReturnNode(true,0);
//        }
//
//        if (isBa(root.left).isBa == false || isBa(root.right).isBa == false){
//            return new ReturnNode(false,0);
//        }
//
//        int left = isBa(root.left).depth;
//        int right = isBa(root.right).depth;
//        if (Math.abs(left - right) > 1){
//            return new ReturnNode(false,0);
//        }
//        return new ReturnNode(true,Math.max(left,right) + 1);
//    }
//
//    public int[] singleNumbers(int[] nums) {
//        int[] arr = new int[2];
//        Map<Integer,Boolean> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (map.containsKey(nums[i])){
//                map.put(nums[i],true);
//            }else {
//                map.put(nums[i],false);
//            }
//        }
//
//        int k = 0;
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (map.get(nums[i]) == false){
//                arr[k++] = nums[i];
//            }
//        }
//        return arr;
//    }
}
