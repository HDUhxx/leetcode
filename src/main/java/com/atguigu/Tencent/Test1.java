package com.atguigu.Tencent;

import java.time.temporal.ValueRange;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        t.mySqrt(8);
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1,r = x/2;
        while (l < r){
            long mid = l + (r - l)/2;
            if (mid * mid < x){
                l = (int) mid;
            }else if (mid * mid > x){
                r = (int) (mid - 1);
            }
        }

        return l;
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        double half = myPow(x,n/2);
        double rest = myPow(x,n % 2);
        return half * half * rest;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];//左边的乘积
        }

        int right = 1;
        for (int i = nums.length - 1 ;i >= 0; i--) {
            res[i] *= right;//右边的乘积
            right *= nums[i];
        }

        return res;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = insertionSortList(head.next);
        ListNode pre = new ListNode(-1,cur);
        ListNode preHead = pre;
        while (cur != null){
            if (head.val > cur.val){
                cur = cur.next;
                pre = pre.next;
            }else {
                break;
            }
        }
        pre.next = head;
        pre.next.next = cur;

        return preHead.next;
    }




    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 0) return false;
        int target = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) return true;
            if (target < nums[i]) return false;
        }

        boolean[] dp = new boolean[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int money = root.val;
        if (root.left != null){
             money +=  rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){
            money += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(money,rob(root.left) + rob(root.right));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars = text1.toCharArray();
        char[] chars1 = text2.toCharArray();
        if (chars.length == 0 || chars1.length == 0) return 0;
        int[][] dp = new int[chars.length + 1][chars1.length + 1];
        dp[0][0] = 0;
        for (int i = 1; i < chars.length + 1; i++) {
            for (int j = 1; j < chars1.length + 1; j++) {
                if (chars[i - 1] == chars[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        return dp[chars.length][chars1.length];
    }


    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0){
                dp[i][0] = Math.min(dp[i - 1][0] * nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1] * nums[i],nums[i]);
            }else {
                dp[i][0] = Math.min(dp[i - 1][1] * nums[i],nums[i]);
                dp[i][1] = Math.max(dp[i - 1][0] * nums[i],nums[i]);
            }
        }

        int res = nums[0];
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i][1]);
        }
        return res;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }

        return isSubStructure(A.left,B) || isSubStructure(A.right,B) || isSub(A,B);
    }

    private boolean isSub(TreeNode a, TreeNode b) {
        if (b == null){
            return true;
        }
        if (a == null){
            return false;
        }


        return a.val == b.val && isSub(a.left,b.left) && isSub(a.right,b.right);
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return pathSum(root.left,sum) + pathSum(root.right,sum) + help(root,sum);
    }

    private int help(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        sum -= root.val;
        int count = sum == 0 ? 1 : 0;
        count += help(root.left,sum);
        count += help(root.right,sum);
        return count;
    }

    /*public ListNode sortList(ListNode head) {
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

    }*/

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
