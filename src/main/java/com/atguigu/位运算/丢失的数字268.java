package com.atguigu.位运算;

import java.util.Arrays;

public class 丢失的数字268
{
    public static void main(String[] args)
    {

    }


    /**
     *              [0,1,2,3]+4
     *              [0,1,3,4]
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
        {
            res ^= i ^ nums[i];
        }
        return res^nums.length;//可能出现【0，1，2】的情况，需要在和num.length异或一下




//        Arrays.sort(nums);
//
//        int res = 0;
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (nums[i] != i){
//                res = i;
//                break;
//            }
//        }
//        return res;
    }

}
