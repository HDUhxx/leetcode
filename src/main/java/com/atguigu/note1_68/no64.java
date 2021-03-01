package com.atguigu.note1_68;

public class no64
{

    public int sumNums1(int n) {
        boolean x = n > 1 && (n += sumNums1(n - 1)) > 0;
        return n;
    }

    //常规递归
    public int sumNums(int n)
    {
        if (n == 1)
        {
            return n;
        }

        n += sumNums(n - 1);

        return n;
    }
}
