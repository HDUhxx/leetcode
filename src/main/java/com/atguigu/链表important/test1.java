package com.atguigu.链表important;


import java.util.*;
import java.util.logging.Level;

public class test1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode tail = head;
        for (int i = 0; i < k - 1; i++) {
            if (tail == null){
                return head;
            }
            tail = tail.next;
        }

        if (tail == null) return head;
        ListNode next = tail.next;
        ListNode node = reverseKGroup(next,k);
        tail.next = null;
        ListNode reverse = reverse(head);
        head.next = node;
        return reverse;
    }

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return merger(left,right);

    }

    private ListNode merger(ListNode left, ListNode right) {
        if (left == null && right == null){
            return null;
        }
        if (left == null || right == null){
            return left == null ? right : left;
        }

        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (left != null && right != null){
            if (left.val > right.val){
                res.next = right;
                right = right.next;
            }else {
                res.next = left;
                left = left.next;
            }
            res = res.next;
        }

        res.next = left == null ? right : left;

        return temp.next;
    }
}
