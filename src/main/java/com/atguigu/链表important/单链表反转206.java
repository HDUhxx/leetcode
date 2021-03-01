package com.atguigu.链表important;

public class 单链表反转206
{
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        //递归
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public ListNode reverseList1(ListNode head) {

        //双指针迭代
        ListNode pre = null;
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null){
            temp = curr.next;//temp来保存curr.next
            curr.next = pre;//curr指向前一个节点，实现局部的反转
            pre = curr;//把这两个指针都向后一位
            curr = temp;
        }
        return pre;
    }



}
