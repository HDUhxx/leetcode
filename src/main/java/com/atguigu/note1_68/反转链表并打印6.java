package com.atguigu.note1_68;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 反转链表并打印6
{
    public int[] reversePrint(ListNode head) {
//        Queue<Integer> list = new ArrayDeque<>();
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;

        }
        int[] res = new int[list.size()];
        int i = 0;
        while (!list.isEmpty()){
//            res[i ++] = ((ArrayDeque<Integer>) list).pollLast();
            res[i ++] = list.pollLast();
        }
        return res;

    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

