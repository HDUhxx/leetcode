package com.atguigu.Tencent;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode construct(int[] nums){
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode h = head;
        for (int i = 1; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        return h;
    }
}
