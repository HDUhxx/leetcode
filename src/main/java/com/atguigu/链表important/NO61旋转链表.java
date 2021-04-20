package com.atguigu.链表important;

public class NO61旋转链表 {
    /**
     *  向右旋转k次
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        //1、首尾相连
        int len = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            len ++;
        }
        tail.next = head;
        k = k % len;

        //2、从尾部走 len - k步，找到要返回的节点，
        for (int i = 0; i < len - k; i++) {
            tail = tail.next;
        }

        //3、断开连接
        ListNode res = tail.next;
        tail.next = null;

        return res;
    }
}
