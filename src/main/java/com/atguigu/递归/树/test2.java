package com.atguigu.递归.树;

import java.util.*;

public class test2 {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null){
            return root.val;
        }
        int two = rob(root.left) + rob(root.right);
        int one = root.val;
        if (root.left != null){
            one += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){
            one += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(one,two);
    }

    List<Integer> list = new ArrayList<>();

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    private void reverse(int[] nums,int left,int right){
        int temp = 0;
        while (left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return pathSum(root.left,sum) + pathSum(root.right,sum) + dfs1(root,sum);
    }

    private int dfs1(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        sum -= root.val;
        int count = sum == 0 ? 1 : 0;
        count += dfs1(root.left,sum);
        count += dfs1(root.right,sum);
        return count;
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null) return new TreeNode(head.val);

        ListNode fast = head.next;
        ListNode slow = head;
        ListNode pre = slow;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }



    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return help(postorder,0,postorder.length - 1);
    }

    private boolean help(int[] postorder, int left, int right) {
        if (left >= right) return true;

        int mid = left;
        while (postorder[mid] < postorder[right]){
            mid++;
        }
        int temp = mid;
        while (temp < right){
            if (postorder[temp++] < postorder[right]){
                return false;
            }
        }

        return help(postorder,left,mid - 1) && help(postorder,mid,right - 1);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> path = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                path.add(poll.val);
                if (poll.left != null){
                    q.add(poll.left);
                }
                if (poll.right != null){
                    q.add(poll.right);
                }
            }
            if (res.size() % 2 == 1) Collections.reverse(path);
            res.add(new ArrayList<>(path));
        }
        return res;
    }

//    public int[] levelOrder(TreeNode root) {
//        if (root == null){
//            return new int[]{};
//        }
//
//        Queue<TreeNode> q = new ArrayDeque<>();
//        ArrayList<Integer> res = new ArrayList<>();
//        q.add(root);
//        while (!q.isEmpty()){
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = q.poll();
//                res.add(poll.val);
//                if (poll.left != null) q.add(poll.left);
//                if (poll.right != null) q.add(poll.right);
//
//            }
//        }
//
//        int[] r = new int[res.size()];
//        int k = 0;
//        for (int i : res){
//            r[k ++] = i;
//        }
//        return r;
//    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }

        return iszichuan(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean iszichuan(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return iszichuan(a.left,b.left) && iszichuan(a.right,b.right);
    }


    //顺序打印矩阵
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
//        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        int[] res = new int[matrix.length * matrix[0].length];
//        dfs(res,used,matrix,0,0,0);
//        return res;
        int k = 0;
        int top = 0,bottom = matrix.length - 1,left = 0,right = matrix[0].length - 1;

        while (top <= bottom && left <= right){
            for (int i = left; i <= right; i++) {
                res[k ++] = matrix[top][i];
            }
            top ++;
            for (int i = top; i <= bottom; i++) {
                res[k ++] = matrix[i][right];
            }
            right --;
            for (int i = right; i >= 0; i--) {
                res[k ++] = matrix[bottom][i];
            }
            bottom --;
            for (int i = bottom; i >= 0; i++) {
                res[k ++] = matrix[i][left];
            }
            left --;
        }

        return res;

    }

    private void dfs(int[] res, boolean[][] used, int[][] matrix, int i, int j,int k) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || used[i][j]){
            return;
        }
        res[k ++] = matrix[i][j];
        used[i][j] = true;
        dfs(res,used,matrix,i,j + 1,k);
        dfs(res,used,matrix,i + 1,j,k);
        dfs(res,used,matrix,i,j - 1,k);
        dfs(res,used,matrix,i - 1,j,k);
    }


    //二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }


    //t是不是s的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;

        return isZi(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private boolean isZi(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        return isZi(s.left,t.left) && isZi(s.right,t.right);
    }

    //是不是对称二叉树
    public boolean isSymmetric(TreeNode root) {
        return isduichen(root,root);
    }

    private boolean isduichen(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }

        return node1.val == node2.val && isduichen(node1.left,node2.right) && isduichen(node1.right,node2.left);
    }
}
