package com.atguigu.note1_68;

public class 合并两个排序的链表25
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode pre = curr;

        while (l1 != null && l2 != null){
            if ((l1.val >= l2.val)){
                pre.next = l2;
                l2 = l2.next;
            }else {
                pre.next = l1;
                l1 = l1.next;
            }
        }

        pre.next = l1 == null ? l2 : l1;

        return curr.next;
    }
}
