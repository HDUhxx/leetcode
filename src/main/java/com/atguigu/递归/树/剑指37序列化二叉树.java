package com.atguigu.递归.树;

import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 剑指37序列化二叉树
{
    public static void main(String[] args)
    {
//        String s = "1,2,3";
//        String[] split = s.split(",");
//        for (int i = 0; i < split.length; i++)
//        {
//            System.out.print(split[i]);
//        }
//        String s1 = String.valueOf("123");
//        Integer integer = Integer.valueOf(124);


//        Integer[] nums = {1,2,3,null,null,4,5};
//        TreeNode root = TreeNode.constructTree(nums);
//        String s = serialize(root);
//        System.out.println(s);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(null);
    }

//    public static String serialize(TreeNode root) {
//        if(root == null) return "[]";
//        StringBuilder res = new StringBuilder("[");
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if(node != null) {
//                res.append(node.val + ",");
//                queue.add(node.left);
//                queue.add(node.right);
//            }
//            else res.append("null,");
//        }
//        res.deleteCharAt(res.length() - 1);
//        res.append("]");
//        return res.toString();
//    }
//
//    public TreeNode deserialize(String data) {
//        if(data.equals("[]")) return null;
//        String[] vals = data.substring(1, data.length() - 1).split(",");
//        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
//        Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//        int i = 1;
//        while(!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if(!vals[i].equals("null")) {
//                node.left = new TreeNode(Integer.parseInt(vals[i]));
//                queue.add(node.left);
//            }
//            i++;
//            if(!vals[i].equals("null")) {
//                node.right = new TreeNode(Integer.parseInt(vals[i]));
//                queue.add(node.right);
//            }
//            i++;
//        }
//        return root;
//    }


     //Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder("[");
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll != null){
                sb.append(poll.val + ",");
                queue.add(poll.left);
                queue.add(poll.right);
            }else {
                sb.append("null,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1,data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i ++;

            if (!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i ++;
        }

        return root;
    }
}
