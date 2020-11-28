package com.atguigu.位运算;

public class 汉明距离461
{
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args)
    {
        int x = 1;
        int y = 4;
        int i = hammingDistance(x, y);
        System.out.println(i);
    }
}
