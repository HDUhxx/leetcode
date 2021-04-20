package com.atguigu.面试常问.demo07_rank;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,23,-567,70, -1,900, 4561};
        arr = quickSort(arr, 0, 8);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSort(int[] arr,int left,int right){
        if (left > right){
            return arr;
        }else {
            //左边第一个作为基准
            int l = left;
            int r = right;
            int pivot = arr[left];
            int temp = 0;

            while (left < right){
                while (arr[right] >= pivot && left < right){
                    right --;
                }
                while (arr[left] <= pivot && left < right){
                    left ++;
                }

                //交换两个指针最终标记的数字
                if (left < right){
                    temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }
            //这时两个指针重合，交换最左边的基准与重合的地方
            temp = arr[l];
            arr[l] = arr[left];
            arr[left] = temp;

            quickSort(arr,l,left - 1);
            quickSort(arr,right + 1,r);
            return arr;
        }
    }
}
