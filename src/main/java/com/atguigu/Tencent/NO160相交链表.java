package com.atguigu.Tencent;

public class NO160相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB){
            nodeA = nodeA.next == null ? headB : nodeA.next;
            nodeB = nodeB.next == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}
