package com.atguigu.DP;


import java.util.Arrays;
import java.util.List;

/**
 * 最基础经典的dp
 *
 * 那么环形抢劫又是什么样的呢？
 *  细心的我们发现： 只需要把问题转换成 只要前n-1或者只要后n-1个
 *  Arrays.copyOfRange(T[ ] original,int from,int to)
 *
 */
public class 强盗
{
    public static void main(String[] args)
    {
       /* String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = s1+s2;
*/
       String[] tempArray = new String[]{"A","B"};
        List<String> tempList = Arrays.asList(tempArray);
        tempList.add("C");
        System.out.println(tempList.toString());
//
//        int[] arr = {1,2,3,1};
//        int rob = rob(arr);
//        System.out.println(rob);
    }
    public static int rob(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] OPT = new int[nums.length];
        OPT[0] = nums[0];
        OPT[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++)
        {
            OPT[i] = Math.max(nums[i] + OPT[i - 2],OPT[i - 1]);
        }

        //包括起始的，不包括结束的n - 1！
        Arrays.copyOfRange(nums,0, - 1);
        return OPT[nums.length - 1];


    }

}
