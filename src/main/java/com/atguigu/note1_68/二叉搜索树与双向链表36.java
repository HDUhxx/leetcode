package com.atguigu.note1_68;

public class 二叉搜索树与双向链表36
{
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }

//        helper(root);
        return new Node(0);
    }
}
