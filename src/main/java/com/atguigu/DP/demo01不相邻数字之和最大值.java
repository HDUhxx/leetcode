package com.atguigu.DP;

public class demo01不相邻数字之和最大值
{

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6};
        int i = maxSum(arr);
        System.out.println(i);
    }

    public static int maxSum(int[] arr){
        int[] OPT = new int[arr.length];
        OPT[0] = arr[0];
        if (arr[0] > arr[1]){
            OPT[1] = arr[0];
        }else {
            OPT[1] = arr[1];
        }
        for (int i = 2; i < arr.length; i++)
        {
            int A = OPT[i - 1] ;
            int B = arr[i] + OPT[i - 2];
            if (A > B){
                OPT[i] = A;
            }else {
                OPT[i] = B;
            }
        }
        return OPT[arr.length - 1];
    }
}
