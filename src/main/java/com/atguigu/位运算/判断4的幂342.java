package com.atguigu.位运算;

public class 判断4的幂342
{
    public boolean isPowerOfFour(int n) {
        if(n == 0){
            return false;
        }

        return ((n & (n - 1)) == 0) && n%3 == 1;
    }
}
