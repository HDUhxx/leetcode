package com.atguigu.note1_68;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 复杂链表的复制35
{

    /** 迭代
     *  map key 存放原来的Node
     *      value 存放复制的Node
     *
     *  第一个循环存放Node
     *  第二个循环复制 next、random
     * @param head
     * @return
     */
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


    /**
     *      递归
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        Map<Node,Node> map = new HashMap<>();
        return dfs1(head,map);
    }

    private Node dfs1(Node head, Map<Node, Node> map) {
        if (head == null) return null;
        if (map.containsKey(head)){
            return map.get(head);
        }
        Node node = new Node(head.val);
        map.put(head,node);
        node.next = dfs1(head.next,map);
        node.random = dfs1(head.random,map);
        return node;
    }
}
