package com.atguigu.递归.树;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class NO117填充右侧节点2 {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                if (pre != null){
                    pre.next = poll;
                }
                pre = poll;

                if (poll.left != null){
                    q.add(poll.left);
                }
                if (poll.right != null){
                    q.add(poll.right);
                }
            }
        }

        return root;
    }
}
