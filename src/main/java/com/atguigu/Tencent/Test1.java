package com.atguigu.Tencent;

import java.time.temporal.ValueRange;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        ListNode construct = ListNode.construct(nums);
        sortedListToBST(construct);
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode PreHead = new ListNode(0,head);
        ListNode pre = PreHead;
        while (head != null){
            if (head.val == val){
                pre.next = head.next;
            }else {
                pre = pre.next;
            }
            head = head.next;
        }
        return PreHead.next;
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int i = 0,j = nums.length - 1;
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }
        i = 0;
        j = k - 1;
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs2(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    private int dfs2(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }

        sum -= root.val;
        int res =sum == 0 ? 1 : 0;
        dfs2(root.left,sum);
        dfs2(root.right,sum);
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
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
        dfs1(root,0);
        return sum;
    }

    private void dfs1(TreeNode root, int i) {
        if (root == null){
            return;
        }
        i  = i * 10 + root.val;
        if (root.left == null && root.right == null){
            sum += i;
            return;
        }
        dfs1(root.left,i);
        dfs1(root.right,i);
    }

    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left != null){
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connect(root.left);
            connect(root.right);
        }
        return root;
    }



    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode pre = new ListNode(0,head);
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast == null || fast.next == null) break;
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        pre.next =  null;
        root.left = sortedListToBST(head);
        return root;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> path = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                path.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(0,new ArrayList<>(path));
        }
        return res;
    }

    long pre = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val <= pre){
            return false;
        }
        pre = root.val;
        if (!isValidBST(root.right)){
            return false;
        }
        return true;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = n;
            n *= nums[i];
        }
        n = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= n;
            res[i] = nums[i];
        }
        return res;
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
