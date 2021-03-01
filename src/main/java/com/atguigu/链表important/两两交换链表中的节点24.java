package com.atguigu.链表important;

public class 两两交换链表中的节点24
{

    //两两交换，可以考虑使用递归写
    //递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return head;
    }

    //再想想NO.24
    public ListNode swapPairs1(ListNode head) {
        ListNode pre = new ListNode(0,head);
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;

            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return pre.next;
    }
}
