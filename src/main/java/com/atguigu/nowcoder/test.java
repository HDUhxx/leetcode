package com.atguigu.nowcoder;

import java.lang.reflect.Array;
import java.util.*;

public class test {
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] arr = new int[128];
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'a']++;
        }
        int odd = 0;
        for (int i : arr){
            odd += i/2*2;
        }

        if (s.length() > odd + 1) {
            return false;
        }else {
            return true;
        }
    }
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length())return false;
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length)return list;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> temp = new ArrayDeque<>();
        temp.add(root);
        while (!temp.isEmpty()){
            ArrayList<Integer> path = new ArrayList<>();
            int size = temp.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = temp.poll();
                path.add(poll.val);
                if (poll.left != null){
                    temp.add(poll.left);
                }
                if (poll.right!= null){
                    temp.add(poll.right);
                }
            }
            res.add(path);
        }

        return res;

    }
    public int jumpFloor(int target) {
        if (target == 0) return 1;
        if (target == 1) return 1;
        if (target == 2) return 2;
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        ListNode preHead = new ListNode(0);
        ListNode pre = preHead;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }else {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            }
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead;
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            if (fast == null || fast.next == null)return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }

        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

//    public static int[] bubbleSort(int[] array) {
//        if (array.length == 0) return array;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array.length - i - 1; j++) {
//                int temp = array[i]
//            }
//        }
//    }
}
