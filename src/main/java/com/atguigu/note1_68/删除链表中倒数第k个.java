package com.atguigu.note1_68;

public class 删除链表中倒数第k个
{
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode fast = head;
        ListNode slow = pre;
        for (int i = 0; i < k; i++)
        {
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow.next;
    }
}
