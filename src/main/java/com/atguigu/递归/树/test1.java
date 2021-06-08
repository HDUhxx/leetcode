package com.atguigu.递归.树;

import lombok.val;

import javax.xml.ws.soap.Addressing;
import java.util.*;

public class test1 {



    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue< TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                right = poll.val;
                if (poll.left != null) q.add(poll.left);
                if (poll.right != null) q.add(poll.right);
            }
            res.add(right);
        }
        return res;
    }

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs1(root,0);
        return sum;
    }

    private void dfs1(TreeNode root, int i) {
        if (root == null) return;
        i = i * 10 + root.val;
        if (root.left == null && root.right == null){
            sum += i;
        }
        dfs1(root.left,i);
        dfs1(root.right,i);
    }

    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                if (pre != null){
                    pre.next = poll;
                }
                pre = poll;
                if (poll.left != null){
                    q.add(poll.left);
                    q.add(poll.right);
                }
            }
        }
        return root;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> path = new ArrayList<>();
        int sum = 0;
        dfs(root,res,path,sum,targetSum);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, List<Integer> path, int sum, int targetSum) {
        if (root == null){
            return;
        }
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }

        path.add(root.val);
        dfs(root.left,res,path,sum,targetSum);
        dfs(root.right,res,path,sum,targetSum);
        path.remove(path.size() - 1);
    }
}


