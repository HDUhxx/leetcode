package com.atguigu.hot100;

public class NO172阶乘后的零 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5){
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
