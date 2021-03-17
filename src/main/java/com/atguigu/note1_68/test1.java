package com.atguigu.note1_68;


import sun.misc.FpUtils;
import sun.misc.LRUCache;

import javax.annotation.PostConstruct;
import java.util.*;

public class test1{

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;

        return isSubStructure(A.left,B) || isSubStructure(A.right,B) || heler1(A,B);
    }

    private boolean heler1(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && heler1(a.left,b.left) && heler1(a.right,b.right);
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return sum == 0 ? 1 : 0;
        }

        return pathSum(root.left,sum) + pathSum(root.right,sum) + helper(root,sum);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        int count = sum == 0 ? 1 : 0;
        count += helper(root.left,sum - root.val);
        count += helper(root.right,sum - root.val);
        return count;
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new ArrayList<>();
        if (tree == null) return new ListNode[]{};
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(tree);
        while (!q.isEmpty()){
            ListNode pre = new ListNode(- 1);
            ListNode preHead = pre;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                ListNode cur = new ListNode(poll.val);
                pre.next = cur;
                pre = pre.next;
                if (poll.left != null){
                    q.add(poll.left);
                }
                if (poll.right != null){
                    q.add(poll.right);
                }
            }
            res.add(preHead.next);
        }

        ListNode[] result = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return help(postorder,0,postorder.length - 1);
    }

    private boolean help(int[] postorder, int left, int right) {
        if (left >= right) return true;

        int mid = left;
        while (postorder[mid] < postorder[right]){
            mid ++;
        }

        int temp = mid;
        for (int i = temp; i < right; i++) {
            if (postorder[temp] < postorder[right]){
                return false;
            }
        }

        return help(postorder,left,mid - 1) && help(postorder,mid,right - 1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root ==  null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length - 1;i >= 0; i++) {
            if (s1[i].equals("")) continue;
            stringBuilder.append(s1[i] + " ");
        }

        return stringBuilder.toString().trim();
    }

    class ReturnNode{
        boolean isBa;
        int len;

        public ReturnNode(boolean isBa, int len) {
            this.isBa = isBa;
            this.len = len;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }

        public boolean isBa() {
            return isBa;
        }

        public void setBa(boolean ba) {
            isBa = ba;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isbalance(root).isBa;
    }

    private ReturnNode isbalance(TreeNode root) {
        if (root == null){
            return new ReturnNode(true,0);
        }

        ReturnNode left = isbalance(root.left);
        ReturnNode right = isbalance(root.right);
        if (Math.abs(left.len - right.len) <= 1 && left.isBa && right.isBa){
            return new ReturnNode(true,Math.max(left.len,right.len) + 1);
        }else {
            return new ReturnNode(false,Math.max(left.len,right.len) + 1);
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }

    int res = 0;
    public int kthLargest(TreeNode root, int k) {

        dfs4(root,k);
        return res;
    }

    private void dfs4(TreeNode root, int k) {
        if (root == null){
            return;
        }
        dfs4(root.right,k);
        if (--k == 0) res = root.val;

        dfs4(root.left,k);

    }


    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int two = 0,three = 0,five = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[two] * 2,Math.min(dp[three] * 3,dp[five] * 5));

            if (dp[i] == dp[two] * 2){
                two ++;
            }
            if (dp[i] == dp[three] * 3){
                three ++;
            }
            if (dp[i] == dp[five] * five){
                five ++;
            }
        }

        return dp[n - 1];
    }

    public int maxValue(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }

        public int translateNum(int num) {
            String s = String.valueOf(num);
            if (s.length() < 2) return 1;
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                String temp = s.substring(i - 2,i);
                if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
                    dp[i] = dp[i - 1] + dp[i - 2];
                }else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[dp.length - 1];
        }

    private int dfs3(String s, int i) {
        if (i == 0) return 1;
        String temp = s.substring(i - 1,i + 1);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
            return dfs3(s,i - 1) + dfs3(s,i - 2);
        }else {
            return dfs3(s,i - 1);
        }
    }


    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        if (s.length() == 0) return new String[]{};
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs2(res,sb,chars,0);
        String[] r = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    private void dfs2(ArrayList<String> res, StringBuilder sb, char[] chars, int begin) {
        if (sb.length() == chars.length){
            res.add(sb.toString());
            return;
        }

        for (int i = begin; i < chars.length; i++) {
            sb.append(chars[i]);
            dfs2(res,sb,chars,i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


    private void dfs1(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if (root == null){
            return;
        }

        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        dfs1(res,path,root,sum);

        dfs1(res,path,root,sum);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)return res;
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
            if (res.size()%2 == 1){
                Collections.reverse(path);
            }
            res.add(new ArrayList<>(path));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        test1 test1 = new test1();
        int i = test1.minArray(nums);
        System.out.println(i);
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }

        int[] res = new int[matrix.length * matrix[0].length];
        int n = 0;
        int top = 0,bottom = matrix.length - 1;
        int left = 0,right = matrix[0].length - 1;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++) {
                res[n ++] = matrix[top][i];
            }
            top--;

            for (int i = top; i <= bottom; i++) {
                res[n ++] = matrix[i][right];
            }
            right --;

            for (int i = right; i >= left && top <= bottom; i--) {
                res[n ++] = matrix[bottom][i];
            }
            bottom --;

            for (int i = bottom; i >= top && left <= right; i--) {
                res[n ++] = matrix[i][left];
            }
            left ++;
        }

        return res;
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n >= 0) {
            return pow(x,n);
        }else {
            return pow(1/x,-n);
        }
    }

    private double pow(double x,int n){
        if (n == 0)return 1;
        double res = pow(x,n/2);
        if (n/2 == 0) {
            return res * res;
        }else {
            return res * res * x;
        }

    }

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            //左边找到偶数，右边找到奇数
        }

        return nums;
    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (numbers[mid] > numbers[left]){
                left = mid + 1;
            }else if (numbers[mid] < numbers[left]){
                right = mid;
            }else {
                right --;
            }
        }
        return numbers[left];
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return  null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]){
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i + 1),Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i + 1,preorder.length),Arrays.copyOfRange(inorder,i + 1,inorder.length));
            }
        }
        return root;
    }

    //5
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new LinkedList<>();
        dfs(head,list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(ListNode head, List<Integer> list) {
        if (head == null){
            return;
        }
        dfs(head.next,list);
        list.add(head.val);
    }

    //4
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = 0,n = matrix[0].length;
        while (m < matrix.length && n >= 0){
            if (matrix[m][n] > target){
                n --;
            }else if (matrix[m][n] < target){
                m ++;
            }else {
                return true;
            }
        }
        return false;
    }
}


