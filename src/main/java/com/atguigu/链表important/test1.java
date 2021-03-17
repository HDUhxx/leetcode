package com.atguigu.链表important;


import java.util.*;

public class test1 {



    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) /2;
            if (nums[mid] == mid){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }


        LinkedList<Integer> list = new LinkedList<>();
    public int[] reversePrint(ListNode head) {
        dfs(head);
        int[] res = new int[list.size()];
        int i = 0;
        while (!list.isEmpty()){
            res[i ++] = list.poll();
        }
        return res;
    }

    private void dfs(ListNode head) {
        if (head == null){
            return;
        }
        dfs(head.next);
        list.add(head.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2){
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }

        return node1;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        while (l1 != null){
            q1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            q2.add(l2.val);
            l2 = l2.next;
        }

        ListNode res = new ListNode();
        ListNode cur = res;

        int carry = 0;
        while (!q1.isEmpty() || !q2.isEmpty() || carry != 0){
            int a = q1.isEmpty() ? 0 : ((ArrayDeque<Integer>) q1).pollLast();
            int b = q2.isEmpty() ? 0 : ((ArrayDeque<Integer>) q2).pollLast();
            int sum = a + b;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            node.next = cur;
            cur = node;
        }

        return res;
    }


        public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }



    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode evenCur = evenHead;

        while (evenCur != null && evenCur.next !=  null){
            odd.next = evenCur.next;
            odd = odd.next;

            evenCur.next = evenCur.next.next;
            evenCur = evenCur.next;
        }

        odd.next = evenHead;

        return head;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode cur = pre.next;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;

        return pre.next;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = new ListNode(0,head);
        ListNode pre = slow;
        ListNode cur = head;
        for (int i = 0; i < k; i++)
        {
            cur = cur.next;
        }
        while (cur != null){
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return slow.next;
    }

        public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==  null){
            return head;
        }

        ListNode temp = swapPairs(head.next.next);


        head.next.next = head;
        ListNode res = head.next;
        head.next = temp;
        return res;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode node = deleteDuplicates(head.next);
        if (head.val == node.val){
            head.next = node.next;
        }else {
            head.next = node;
        }
        return head;

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*//头插法、栈的性质
        Queue<ListNode> s1 = new LinkedList<>();
        Queue<ListNode> s2 = new LinkedList<>();
        while (l1 != null){
            s1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.add(l2);
            l2 = l2.next;
        }

        ListNode pre = new ListNode(-1);
        ListNode curr = null;

        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int a = s1.isEmpty() ? 0 : ((ArrayDeque<ListNode>) s1).pollLast().val;
            int b = s2.isEmpty() ? 0 : ((LinkedList<ListNode>) s2).pop().val;
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            node.next = curr;
            curr = node;
        }

        return curr;
*/

        ListNode cur = new ListNode();
        ListNode pre = new ListNode();
        pre.next = cur;
        int count = 0;
        while (l1 != null || l2 != null || count != 0){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = (a + b + count);
            count = sum /10;
            int y = sum %10;
            ListNode node = new ListNode(y);
            cur.next = node;
            cur = cur.next;
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
