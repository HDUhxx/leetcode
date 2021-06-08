package com.atguigu.递归.树;

import java.util.Arrays;

public class 重构二叉树
{
    public static TreeNode reConstuct(int[] pre,int[] in) {
        if (pre.length == 0 || in.length == 0){
            return null;
        }

        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++)
        {
            if (pre[0] == in[i]){
                node.left = reConstuct(Arrays.copyOfRange(pre,1,i + 1),Arrays.copyOfRange(in,0,i));
                node.right = reConstuct(Arrays.copyOfRange(pre,i + 1,pre.length),Arrays.copyOfRange(in,i + 1,in.length));
            }
            /*if (pre[i] > pre[0]){
                node.left = reConstuct(Arrays.copyOfRange(pre,1,i ),Arrays.copyOfRange(in,0,i - 1));
                node.right = reConstuct(Arrays.copyOfRange(pre,i,pre.length),Arrays.copyOfRange(in,i,in.length));
            }*/
        }

        return node;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode t = reConstuct(a, b);
        System.out.println(t.left.val);
    }
}
