package com.atguigu.note1_68;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制35
{
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //再想想
    public Node copyRandomList(Node head) {
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while (cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);

    }
}
