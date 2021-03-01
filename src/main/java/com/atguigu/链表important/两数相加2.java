package com.atguigu.链表important;

public class 两数相加2
{
    /**
     *      (2 -> 4 -> 3) + (5 -> 6 -> 4)
     *      7 -> 0 -> 8
     *      342 + 465 = 807
     *      由左到右，低位到高位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode curr = pre;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int cur = a + b + carry;
            carry = cur / 10;
            cur = cur % 10;

            curr.next = new ListNode(cur);
            curr = curr.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }

        return pre.next;
    }
}
