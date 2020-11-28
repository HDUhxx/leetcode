package com.atguigu.bfs;


import java.util.*;

public class 二叉树的层序遍历102 {
    /**
     *      bfs: 使用ArrayDeque来存储一层
     *          取出这一层的元素的同时，还要把下一层放进去
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return null;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode poll = q.poll();
                level.add(poll.val);
                if (poll.left != null){
                    q.add(poll.left);
                }
                if (poll.right != null){
                    q.add(poll.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
