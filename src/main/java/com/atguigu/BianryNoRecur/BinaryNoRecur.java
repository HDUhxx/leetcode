package com.atguigu.BianryNoRecur;

import java.security.PublicKey;

public class BinaryNoRecur
{
    public static void main(String[] args)
    {
        /*int[] arr = {1, 2, 3,5, 12 ,34};
        int i = binaryNoRecur(arr, 4);
        System.out.println(i);*/


    }



    /**
     *      二分查找，非递归的方法
     * @param arr   升序的数组
     * @param target    目标值
     * @return  返回对应的下标
     */
    public static int binaryNoRecur(int[] arr ,int target){
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = (l + r)/2;
            if (arr[mid] > target){
                r = mid - 1;
            }else if (arr[mid] < target){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
