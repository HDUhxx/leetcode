package com.atguigu.链表important;

public class 删除链表中重复的数字83
{

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val){
            head.next = head.next.next;
        }

        return head;
    }
}
