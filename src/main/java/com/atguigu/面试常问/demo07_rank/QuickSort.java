package com.atguigu.面试常问.demo07_rank;

import java.util.Arrays;

public class QuickSort
{
    public static void main(String[] args)
    {

        int[] arr = {-9,78,0,23,23,-567,70, -1,900, 4561};
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
                while (left < right && num[left] <= pivot){
                    left ++;
                }
                while (left < right && num[right] >= pivot){
                    right --;
                }

                if (left < right){
                    temp = num[left];
                    num[left] = num[right];
                    num[right] = temp;
                }
            }
            temp = pivot;
            num[l] = num[left];
            num[left] = pivot;

            quickSort(num,l,left - 1);
            quickSort(num,right + 1,r);
            return num;
        }
    }





}
