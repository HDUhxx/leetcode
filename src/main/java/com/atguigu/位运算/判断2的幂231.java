package com.atguigu.位运算;

public class 判断2的幂231
{
    public boolean isPowerOfTwo(int n) {
        if (n == 0){
            return false;
        }
        long x = (long) n;
//        return (x & -x) == x;
        return ((x &(x - 1)) == 0);
    }
}
