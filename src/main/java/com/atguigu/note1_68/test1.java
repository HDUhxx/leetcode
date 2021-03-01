package com.atguigu.note1_68;


import sun.misc.FpUtils;
import sun.misc.LRUCache;

import java.util.*;

public class test1{
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;
        int i = 1,sign = 1;
        int res = 0;
        if (chars[0] == '-'){
            sign= -1;
        }else if (chars[0] != '+'){
            i = 0;
        }

        for (int j = i; j < chars.length; j++) {
            if (chars[j] > '9' || chars[j] < '0') break;
            int temp = res * 10 + (chars[j] - '0');
            if (temp / 10 != res) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = temp;
        }

        return res * sign;
    }

    public String reverseWords(String s) {
        String[] res = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == "") continue;
            sb.append(res[i] + " ");
        }

        return sb.toString().trim();
    }


        public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),2);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 2){
                return s.charAt(i);
            }
        }

        return ' ';
    }


        public int nthUglyNumber(int n) {
        int[]dp = new int[n];
        dp[0] = 1;
        int two = 0,three = 0,five = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[two] * 2,Math.min(dp[three] * 3,dp[five] * 5));

            if (dp[i] == dp[two] * 2){
                two++;
            }
            if (dp[i] == dp[three] * 3){
                three ++;
            }
            if (dp[i] == dp[five] * 5){
                five ++;
            }
        }

        return dp[n - 1];
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
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i -1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

        public int translateNum(int num) {
        String s = String.valueOf(num);
        return dfs1(s,s.length() - 1);

    }

    private int dfs1(String s, int i) {
        if (i <= 0) return 1;
        int res = dfs1(s,i - 1);
        String temp = s.substring(i - 1,i + 1);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
            res += dfs1(s,i - 2);
        }
        return res;
    }


    public  int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0){
                dp[i] = nums[i];
            }else {
                dp[i] = nums[i] + dp[i - 1];
            }
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }

        public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        res = Arrays.copyOfRange(arr,0,k);
        return res;
    }


        public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) return new String[]{};

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[s.length()];
        Arrays.sort(chars);
        dfs(res,sb,chars,used,0);
        String [] r = new String[res.size()];
        int  i = 0;
        for (String s1 : res){
            r[i ++] = s1;
        }
        return r;
    }

    private void dfs(List<String> res, StringBuilder sb, char[] chars, boolean[] used, int index) {
        if (sb.length() == chars.length){
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i -1]){
                continue;
            }
            if (!used[i]){
                sb.append(chars[i]);
                used[i] = true;
                dfs(res,sb,chars,used,i + 1);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode( - 1);
        ListNode res = pre;
        while (l1 != null && l2 != null){
            if (l1.val >= l2.val){
                pre.next = l2;
                l2 = l2.next;
            }else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;

        return res.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {
            curr = curr.next;
        }

        while (curr != null){
            pre = pre.next;
            curr = curr.next;
        }

        return pre.next;
    }

    public int[] exchange(int[] nums) {
        /*int[] res = new int[nums.length];
        int k = 0;
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1){
                res[k ++] = nums[i];
            }else {
                res[j --] = nums[i];
            }
        }

        return res;*/

        if (nums.length < 2) return nums;
        int left = 0,right = nums.length - 1;
        while (left < right){
            while (left < right && (nums[left] & 1) == 1){
                left ++;
            }
            while (left < right && (nums[right] & 1) == 0){
                right ++;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;

        while (pre.next.val != val){
            pre = pre.next;
        }

        pre.next = pre.next.next;

        return curr.next;
    }

    /**
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        if (n >= 0){
            return pow1(x,n);
        }else {
            return pow1(1/x,-n);
        }
    }

    private double pow1(double x, int n) {
        if (n == 0){
            return 1;
        }

        double r = pow1(x,n/2);
        if (n % 2 == 1){
            return r * r *x;
        }else {
            return r * r;
        }
    }



    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());

    }
}


