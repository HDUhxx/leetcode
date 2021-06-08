package com.atguigu.hot100;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class NO993二叉树的堂兄弟节点 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> value = new LinkedList<>();
        queue.add(root);
        value.add(root.val);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                value.poll();
                //先判断是不是兄弟节点？
                if (poll.left != null && poll.right != null){
                    if ((poll.left.val == x && poll.right.val == y) ||
                            (poll.left.val == y && poll.right.val == x)){
                        return false;
                    }
                }

                if (poll.left != null){
                    queue.add(poll.left);
                    value.add(poll.left.val);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                    value.add(poll.right.val);
                }
            }
            //再判断是不是同一层的
            if (value.contains(x) && value.contains(y)){
                return true;
            }
        }
        return false;
    }
}
