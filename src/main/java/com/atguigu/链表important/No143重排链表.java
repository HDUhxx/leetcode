package com.atguigu.链表important;

import java.util.List;

public class No143重排链表 {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur.next != null){
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        ListNode temp = head.next;
        reorderList(temp);
        head.next = cur;
        head.next.next = temp;

    }

}
