package com.atguigu.链表important;

public class NO25k个一组反转链表 {

    /**
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     *
     * 1、不够k个的时候就不反转了
     * 2、不够k个的时候还要反转呢？
     * @param head
     * @param k
     * @return
     */
    //情况1：不够k个时 不进行反转
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode tail = head;
        for (int i = 0; i < k - 1; i++) {
            if (tail == null){
                return head;
            }
            tail = tail.next;
        }
        if (tail == null) return head;
        ListNode next = tail.next;
        tail.next = null;
        ListNode reverse = reverse(head);
        ListNode node = reverseKGroup1(next, k);
        head.next = node;
        return reverse;
    }

    //情况2：不够k个时还进行反转
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode tail = head;
        for (int i = 0; i < k - 1; i++) {
            if (tail == null){
                break;
            }
            tail = tail.next;
        }
        if (tail == null) {
            return reverse(head);
        }else {
            ListNode next = tail.next;
            tail.next = null;
            ListNode reverse = reverse(head);
            ListNode node = reverseKGroup(next, k);
            head.next = node;
            return reverse;
        }
    }

    public ListNode reverse(ListNode root){
        if (root == null || root.next == null){
            return root;
        }
        ListNode node = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return node;
    }
}
