package com.atguigu.DP;

public class 爬楼梯
{
    public static void main(String[] args)
    {
        int i = climbStairs(11);
        System.out.println(i);
    }

    /**
     *      斐波那契
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int nums[] =  new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2;i <= n;i ++){
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}
