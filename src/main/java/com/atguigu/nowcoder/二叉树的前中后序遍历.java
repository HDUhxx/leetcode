package com.atguigu.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前中后序遍历 {

    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        pre(root,list1);
        in(root,list2);
        post(root,list3);
        int[][] res = new int[3][list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            res[0][i] = list1.get(i);
            res[1][i] = list2.get(i);
            res[2][i] = list3.get(i);
        }

        return res;


    }

    private void post(TreeNode root, List<Integer> list3) {
        if (root == null)return;
        post(root.left,list3);
        post(root.right,list3);
        list3.add(root.val);
    }

    private void in(TreeNode root, List<Integer> list2) {
        if (root == null){
            return;
        }
        in(root.left,list2);
        list2.add(root.val);
        in(root.right,list2);
    }

    private void pre(TreeNode root, List<Integer> list1) {
        if (root == null){
            return ;
        }
        list1.add(root.val);
        pre(root.left, list1);
        pre(root.right, list1);
    }


}
