package com.atguigu.链表important;



public class 删除倒数第n个节点
{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0,head);
        //快慢指针
        ListNode fast = head;
        ListNode slow = pre;
        for (int i = 0; i < n; i++)
        {
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return pre.next;
    }
}
