package com.atguigu.递归.树;

public class NO116填充每个节点的右侧节点 {
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null){
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connect(root.left);
            connect(root.right);
        }
        return root;
    }
}
