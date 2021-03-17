package com.atguigu.Tencent;

import java.util.*;

public class Test1 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            TreeNode right = new TreeNode(1);
            for (int i = 0; i < size; i++) {
                right = q.poll();
                if (right.left != null) q.add(right.left);
                if (right.right != null) q.add(right.right);
            }
            res.add(right.val);
        }
        return res;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res,sb,root);
        return res;
    }

    private void dfs(List<String> res, StringBuilder s, TreeNode root) {
        s.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(s.toString());
            return;
        }
        if (root.left != null){
            dfs(res,new StringBuilder(s).append("->"),root.left);
        }
        if (root.right != null){
            dfs(res, new StringBuilder(s).append("->"),root.right);
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);

        ListNode res = new ListNode(-1);
        ListNode h = res;
        while (left != null && right != null){
            if (left.val < right.val){
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left == null ? right : left;
        return res.next;

    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        char[] chars = s.toCharArray();
        int begin = 0,maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin + maxLen);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);
        if (s.length() < 2) return true;
        int i = 0,j = s.length() - 1;
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }

    public int majorityElement(int[] nums) {
        if (nums.length < 3) return nums[0];
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public boolean canWinNim(int n) {
        if (n < 4) return true;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        dp[1] = true;
        dp[2] = true;
        dp[3] = false;

        for (int i = 4; i < n; i++) {
            if (!dp[i - 1] || !dp[i - 2] || !dp[i - 3]){
                dp[i] = true;
            }else {
                dp[i] = false;
            }
        }

        return dp[n - 1];
    }

    public void reverseString(char[] s) {
        char temp = ' ';
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - 1 - i] = temp;
        }
    }
}
