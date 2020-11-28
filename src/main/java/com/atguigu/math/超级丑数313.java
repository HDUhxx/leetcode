package com.atguigu.math;

import org.junit.Test;

public class 超级丑数313
{
    /*public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] a = new int[primes.length];
        for (int i = 1; i < n; i++)
        {

        }
    }*/

    public static void main(String[] args)
    {
        int[] a = new int[20];
        a[0] = 0;
        System.out.print(0+",");
        for (int i = 1; i < a.length; i++)
        {
            a[i] = a[i - 1] + 4;
            System.out.print(a[i] + ",");
        }
    }

    @Test
    public void test1(){
        double[] arr = {1,4,7,10,13,16,18,20,23,25,27,29,31,33,34.5,36,37.6,39,40.4,41.7,43,44,45,46,47,48,48.8,49.6,50.2,51.4,51.8,52.3,52.6,53,53,53,53,53,
                53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53};
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = arr[i] - 1;
            System.out.print(arr[i] + ",");
        }
    }

    @Test
    public void test2(){
        int[] arr = {53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53
                ,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53};
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = arr[i] - 1;
            System.out.print(arr[i] + ",");
        }
    }
}
