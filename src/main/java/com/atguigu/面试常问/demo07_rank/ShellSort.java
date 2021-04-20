package com.atguigu.面试常问.demo07_rank;

import java.util.Arrays;

public class ShellSort
{
    public static void main(String[] args)
    {
        //希尔排序
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        shellSort(arr);
    }


    public static void shellSort(int[] arr){
        int temp = 0;
        for (int i = 5; i < arr.length; i++)
        {
            if (arr[i] < arr[i-5]){
                temp = arr[i];
                arr[i] = arr[i-5];
                arr[i-5] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 5; i < arr.length; i++)
        {
            if (arr[i] < arr[i-5]){
                temp = arr[i];
                arr[i] = arr[i-5];
                arr[i-5] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
