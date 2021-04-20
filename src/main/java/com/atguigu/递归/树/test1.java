package com.atguigu.递归.树;

import javax.xml.ws.soap.Addressing;
import java.util.*;

public class test1 {

//    public int translateNum(int num) {
//        String s = String.valueOf(num);
//
//    }


    public String[] permutation(String s) {
        if (s.length() == 0) return  new String[]{};
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs2(res,sb,chars,used);
        String[] result = new String[res.size()];
        int i = 0;
        for (String str : res){
            result[i ++] = str;
        }
        return result;
    }

    private void dfs2(List<String> res, StringBuilder sb, char[] s, boolean[] used) {
        if (sb.length() == s.length){
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (!used[i]){
                if (i > 0 && s[i] == s[i - 1] && used[i - 1]){
                    continue;
                }
                sb.append(s[i]);
                used[i] = true;
                dfs2(res,sb,s,used);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val){
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i + 1),Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i + 1,preorder.length),Arrays.copyOfRange(inorder,i + 1,inorder.length));
            }
        }
        return root;
    }



    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return pathSum(root.left,sum) + pathSum(root.right,sum) + help(root,sum);
    }

    private int help(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        int count = sum == 0 ? 1 : 0;
        count += help(root.left,sum);
        count += help(root.right,sum);
        return count;
    }

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        dfs1(root,0);
        return sum;
    }

    private void dfs1(TreeNode root, int val) {
        if (root == null)return;
        int k = val * 10 + root.val;

        if (root.left == null && root.right == null){
            sum += k;
        }
        dfs1(root.left,k);
        dfs1(root.right,k);
    }

    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left == null) return root;

        /*root.left.next = root.right;
        root.right.next = root.right.left;
        connect(root.left);
        connect(root.right);
        return root;*/
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


    /*public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        dfs(res,path,root,targetSum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null){
            if (targetSum == 0){
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        dfs(res,path,root.left,targetSum);
        dfs(res,path,root.right,targetSum);
        path.remove(path.size() - 1);
    }*/
}


