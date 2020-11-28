package com.atguigu.双指针;

public class 两数平方和
{
    //633
    public static void main(String[] args)
    {
        int c = 5;
        boolean b = judgeSquareSum(c);
        System.out.println(b);
    }

    //二分查找


    //双指针
    public static boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c) + 1;
        while (i <= j){
            if (i * i + j * j > c){
                j --;
            }else if (i * i + j * j < c){
                i ++;
            }else {
                return true;
            }
        }
        return false;
    }
}
