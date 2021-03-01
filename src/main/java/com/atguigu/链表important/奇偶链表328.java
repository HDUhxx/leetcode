package com.atguigu.链表important;

public class 奇偶链表328
{
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode evenHead = head.next;
        ListNode oddCur = head;
        ListNode evenCur = evenHead;

        while (evenCur != null && evenCur.next != null){
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;
            evenCur.next = evenCur.next.next;
            evenCur = evenCur.next;
        }

        oddCur.next = evenHead;

        return head;
    }
}



 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
