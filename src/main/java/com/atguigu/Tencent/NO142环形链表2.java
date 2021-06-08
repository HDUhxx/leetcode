package com.atguigu.Tencent;


import java.util.List;


public class NO142环形链表2 {
    /** a 环外面的长度、b 环的长度
     * 1、fast = 2 * slow
     * 2、fast = slow + nb(fast与slow相遇时，fast比slow多跑了n圈)
     * 所以 slow再多走 a步就可以到达。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        fast = head;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}




