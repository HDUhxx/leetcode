package com.atguigu.Tencent;

public class NO148排序链表 {
    /**
     * 怎么对链表进行排序？(归并的思路)
     *      思路：1、找到链表的中间
     *            2、合并两个有序链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode midNode = middle(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merger(left,right);
    }

    private ListNode merger(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (left != null && right != null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        cur.next = left == null ? right : left;

        return res.next;
    }

    private ListNode middle(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 拆分、合并写在一起了
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if (fast == null || fast.next == null){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        ListNode res = new ListNode(0);
        ListNode result = res;
        while (right != null && left != null){
            if (left.val < right.val){
                res.next = left;
                left = left.next;
            }else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        res.next = left == null ? right : left;
        return result.next;
    }
}
