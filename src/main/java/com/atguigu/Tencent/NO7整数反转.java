package com.atguigu.Tencent;

public class NO7整数反转
{
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            if (res > 214748364 || res < -214748364) {
                return 0;
            }
            int temp = x % 10;
            res = res * 10 + temp;
            x /= 10;
        }

        return res;
    }
}
