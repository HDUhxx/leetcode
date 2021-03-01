package com.atguigu.分治;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 不同的二叉搜索树95
{
    public List<TreeNode> generateTrees(int n) {
    if (n == 0){
        return new ArrayList<>();
    }

    return helper(1,n);
}

    private List<TreeNode> helper(int start, int end)
    {
        List<TreeNode> list = new ArrayList<>();

        if (start > end){
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++)
        {
            List<TreeNode> left = helper(start,i - 1);
            List<TreeNode> right = helper(i + 1,end);
            for (TreeNode l : left){
                for (TreeNode r :right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }


}



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
