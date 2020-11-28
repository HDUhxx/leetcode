package com.atguigu.math;

import java.util.Arrays;

public class demo01_查找素数
{


    /**
     * 要得到自然数n以内的全部质数，必须把不大于根号n的所有质数的倍数剔除，剩下的就是质数。
     * @param args
     */
    public static void main(String[] args)
    {

    }
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        for (int i = 2; i * i < n; i++)
        {
            if (isPrimes[i]){
                for (int j = i * i; j < n; j += i)
                {
                    isPrimes[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++)
        {
            if (isPrimes[i]){
                count  ++;
            }
        }
        return count;
    }

}
