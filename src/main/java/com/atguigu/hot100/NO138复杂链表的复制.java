package com.atguigu.hot100;

import java.util.HashMap;
import java.util.Map;

public class NO138复杂链表的复制 {
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
