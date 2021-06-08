package com.atguigu.Graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class NO133克隆图 {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                Node node1 = new Node(poll.val);
                node1.neighbors = poll.neighbors;
                if (poll.neighbors != null){
                    for (int j = 0; j < poll.neighbors.size(); j++) {
                        q.add(poll.neighbors.get(i));
                    }
                }
            }
        }
        return node;
    }
}
