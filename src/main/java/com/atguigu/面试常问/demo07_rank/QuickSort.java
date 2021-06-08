package com.atguigu.面试常问.demo07_rank;

import java.util.Arrays;

public class QuickSort
{
    public static void main(String[] args)
    {

//        int[] arr = {-9,78,0,23,23,-567,70, -1,900, 4561};
        int[] arr= {3  ,1  ,2 ,5 , 4  ,6 , 9 ,7 , 10  ,8};
        arr = quickSort(arr, 0, 8);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSort(int[] num, int left, int right) {
        if (left >= right){
            return num;
        }else {
            int temp = 0;
            int l = left;
            int r = right;
            int pivot = num[left];
            while (left < right){
                //有问题，不可以先动 left，
                /*while (left < right && num[left] <= pivot){
                    left ++;
                }
                while (left < right && num[right] >= pivot){
                    right --;
                }*/

                //应该先动右边的，因为最后重合的地方应该是小于pivot的
                while (left < right && num[right] >= pivot){
                    right --;
                }
                while (left < right && num[left] <= pivot){
                    left ++;
                }


                if (left < right){
                    temp = num[left];
                    num[left] = num[right];
                    num[right] = temp;
                }
            }
            num[l] = num[left];
            num[left] = pivot;

            //第一次之后，left与right重合，对左右两边递归
            quickSort(num,l,left - 1);
            quickSort(num,right + 1,r);
            return num;
        }
    }





}
