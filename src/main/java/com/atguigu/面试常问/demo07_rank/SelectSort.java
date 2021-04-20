package com.atguigu.面试常问.demo07_rank;

import java.util.Arrays;

public class SelectSort
{
    //选择排序：选出最小的放在arr[0]
    public static void main(String[] args)
    {
        int[] arr = {3,9,-1,-2,-10};
//        selectSort(arr);
        select2(arr);

        /*int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++)
        {
            arr1[i] = (int)(Math.random()*80000);
        }


        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试选择排序
        select2(arr1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);*/
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i+1; j < arr.length ; j++)
            {
                int temp = 0;
                if (arr[j] < arr[i]){ //本次选择第一个为最小的，然后遍历后面的，如果有比他小的就交换位置，
                    temp = arr[i];    //遍历arr.length-1 次
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }


    //选择排序:一个大循环，要选出最小的和最前面的交换位置
    //          交换位置就需要中间变量min，还需要把找到的最小的表示出来（所以需要下标）
    public static void select2(int[] arr){
        for (int j = 0; j < arr.length - 1; j++)
        {
            int min  = arr[j];//本次选择中最小的
            int minindex = j; //本次选择中最小的下标
            for(int i = j+1; i < arr.length; i++){
                if (arr[i]<min){
                    min = arr[i];
                    minindex = i;
                }
            }
            arr[minindex] = arr[j]; //找到本次选择中最小的，交换位置
            arr[j] = min;
            System.out.println(Arrays.toString(arr));
        }
    }



}
