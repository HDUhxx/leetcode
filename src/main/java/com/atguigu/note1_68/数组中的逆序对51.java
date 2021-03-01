package com.atguigu.note1_68;

import java.util.HashMap;
import java.util.Map;

public class 数组中的逆序对51
{

    //NO.51 经典的分治 再看看

    /**
     *  temp的作用：1、节省空间
     *             2、索引不容易出错
     *
     *    分而治之：第一个递归：分
     *             第二个递归：治
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        //两个for循环超出时间限制

        int len = nums.length;
        if (len < 2){
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++)
        {
            copy[i] = nums[i];
        }
        int [] temp = new int[len];
        return reversePairs(copy,0,len - 1,temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp)
    {
        if (left == right){
            return 0;
        }

        int mid = left + (right - left)/2;
        int reverseLeft = reversePairs(nums,left,mid,temp);
        int reverseRight = reversePairs(nums,mid + 1,right,temp);

        //合并
        int crossPairs = mergerPairs(nums,left,mid,right,temp);

        return reverseLeft + reverseRight + crossPairs;
    }

    private int mergerPairs(int[] nums, int left, int mid, int right, int[] temp)
    {
        for (int i = left; i <= right; i++)
        {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++)
        {
            if (i == mid + 1){
                nums[k] = temp[j];
                j ++;
            }else if (j == right + 1){
                nums[k] = temp[i];
                i ++;
            }else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                i ++;
            }else {
                nums[k] = temp[j];
                j ++;
                count += (mid - i + 1);
            }
        }
        return count;

    }
    //[7,5,6,4]中的逆序对的个数


    public char firstUniqChar(String s) {
//        int[] arr = new int[26];
//
//        for (int i = 0; i < s.length(); i++)
//        {
//            arr[s.charAt(i) - 'a']++;
//        }
//
//
//        for (int i = 0; i < s.length(); i++)
//        {
//            if (arr[s.charAt(i) - 'a'] == 1){
//                return s.charAt(i);
//            }
//        }
//
//        return ' ';

        Map<Character,Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,true);
            }else {
                map.put(c,false);
            }
        }

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (map.get(c) == false){
                return c;
            }
        }

        return ' ';
    }

}
