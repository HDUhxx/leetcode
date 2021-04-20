package com.atguigu.面试常问.demo07_rank;

import java.util.Arrays;

public class BubbleSort
{
    //冒泡排序:先把最大的放在最后，再把第二大的放在倒数第二......
    public static void main(String[] args)
    {
        int[] arr = {3,9,-1,-2,-10};
        /*int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++)
        {
            arr[i] = (int)(Math.random()*80000);
        }
        System.out.println(Arrays.toString(arr));*/
        bubbleSort1(arr);
        System.out.println(Arrays.toString(arr));
        /*for (int j = arr.length-1; j > 0 ; j--)
        {
            for (int i = 0; i < j; i++)
            {
                if (arr[i] > arr[i + 1]){
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] =temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }*/
    }
    public static int[] bubbleSort1(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int temp = 0;
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i] > array[i + 1]){
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public static void bubbleSort(int[] arr){


        int temp = 0;//临时变量
        boolean flag = false; //用来表示在一趟比较中有没有发生交换

        /*for (int j = 0; j < arr.length - 1; j++)
        {
            for (int i = 0; i < arr.length - 1 - i; i++)
            {
                if (arr[i] > arr[i+1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            if (flag == false){
                break;
            }else {
                flag = false; //重置flag，
            }
            System.out.println(Arrays.toString(arr));

        }*/
        for (int j = 0; j < arr.length - 1 ; j++)
        {
            for (int i = 0; i < arr.length - 1 -j; i++)
            {
                if (arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
