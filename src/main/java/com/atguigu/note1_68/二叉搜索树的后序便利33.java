package com.atguigu.note1_68;

public class 二叉搜索树的后序便利33
{
    public static boolean verifyPostorder(int[] postorder) {
        return helper(postorder,0,postorder.length - 1);
    }

    private static boolean helper(int[] postorder, int left, int right)
    {
        if (left >= right){
            return false;
        }

        int mid = left;
        for (int i = left; i < right; i++)
        {
            if (postorder[i] > postorder[right]){
                mid = i;
                break;
            }
        }
        boolean res = true;
        for (int i = mid; i < right; i++)
        {
            if (postorder[i] < postorder[mid]){
                res = false;
            }
        }

        return res && helper(postorder,left,mid) && helper(postorder,mid + 1,right);
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 8, 6, 12, 16, 14, 10};
        boolean b = verifyPostorder(arr);

        System.out.println(b);
    }
}
