package com.atguigu.note1_68;


import com.atguigu.note1_68.Node;
import sun.misc.FpUtils;
import sun.misc.LRUCache;

import javax.annotation.PostConstruct;
import java.util.*;

public class test1{

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);

                map.put(s.charAt(i),i);
                max = Math.max(max,i - left + 1);
            }
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
            if (temp.compareTo("25") <= 0 && temp.compareTo("10") >= 0){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    private int dfs2(String s, int i) {
        if (i < 2){
            return 1;
        }

        int res = dfs2(s,i - 1);
        String temp = s.substring(i - 2,i);
        if (temp.compareTo("25") <= 0 && temp.compareTo("10") >= 0){
            res += dfs2(s,i - 2);
        }
        return res;
    }

    /**
     *  map key 存放原来的Node
     *      value 存放复制的Node
     *
     *  第一个循环存放Node
     *  第二个循环复制 next、random
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        return dfs1(head,map);
    }

    private Node dfs1(Node head, Map<Node, Node> map) {
        if (head == null) return null;
        if (map.containsKey(head)){
            return map.get(head);
        }
        Node node = new Node(head.val);
        map.put(head,node);
        node.next = dfs1(head.next,map);
        node.random = dfs1(head.random,map);
        return node;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res,path,root,sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        path.add(root.val);
        if (sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(res,path,root.left,sum);
        dfs(res,path,root.right,sum);
        path.remove(path.size() - 1);
    }


    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return help(postorder,0,postorder.length - 1);
    }

    private boolean help(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int temp = left;
        while (postorder[temp] < postorder[right]){
            temp ++;
        }

        int temp2 = temp;
        while (temp2 < right){
            if (postorder[temp2 ++] < postorder[right]){
                return false;
            }
        }
        return help(postorder,left,temp - 1) && help(postorder,temp,right - 1);
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
            if (res.size() % 2 == 1){
                Collections.reverse(path);
            }
            res.add(new ArrayList<>(path));
        }
        return res;
    }

    public int hammingWeight(int n) {
//        return Integer.bitCount(n);
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count ++;
        }
        return count;
    }

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            while (nums[left] % 2 == 1){
                left ++;
            }
            while (left < right && nums[right] % 2 == 0){
                right --;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        if (numbers[right] > numbers[left]) return numbers[left];

        while (left < right){
            int mid = left + (right - left)/2;
            if (numbers[mid] > right){
                left = mid + 1;
            }else if (numbers[mid] < right){
                right = mid;
            }else {
                right --;
            }
        }
        return numbers[left];
    }
}


