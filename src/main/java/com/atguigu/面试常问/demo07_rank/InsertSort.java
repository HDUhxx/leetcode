package com.atguigu.面试常问.demo07_rank;

import java.util.Arrays;

public class InsertSort
{
    public static void main(String[] args)
    {
        int[] arr = {101,24,-119,1};
//        insertSort(arr);
        insert1(arr);
    }

    //插入排序：从1，到arr.lenth,每个元素和它前一个比较，
    //          比他大就放在原位，比他小就继续往前比
    public static void insertSort(int[] arr){
        for (int i = 1; i <arr.length ; i++)
        {
            int insertValue = arr[i];
            int insertIndex = i -1;

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex>=0 && insertValue<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }

            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            if (insertIndex + 1 != i){
                arr[insertIndex + 1] = insertValue;
            }

            System.out.println(Arrays.toString(arr));
        }
    }

    public static void insert1(int[] arr){
        for (int i = 1; i < arr.length; i++)
        {
            int insertIndex = i - 1;
            int insertValue = arr[i];

            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }

            arr[insertIndex + 1] = insertValue;
            System.out.println(Arrays.toString(arr));
        }


    }
}
