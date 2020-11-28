package com.atguigu.位运算;

public class 计算1到n的二进制中有多少个1
{
    public int[] countBits(int num) {
        int[] nums = new int[num + 1];
        for (int i = 0; i < num + 1; i++)
        {
            nums[i] = Integer.bitCount(i);
        }
        return nums;
    }
}
