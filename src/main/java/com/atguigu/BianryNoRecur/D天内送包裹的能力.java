package com.atguigu.BianryNoRecur;

public class D天内送包裹的能力
{
    public static void main(String[] args)
    {
        int[] weights = {3,3,3,3,3,3};
        int d = 2;
        int i = shipWithinDays(weights, d);
        System.out.println(i);

//        canCap(weights,2,9);
    }

    public static int shipWithinDays(int[] weights, int D) {
        int right = 0;
        int left = 0;
        for (int i = 0; i < weights.length; i++)
        {
            left = Math.max(left,weights[i]);
            right += weights[i];
        }

        while (left < right){
            int mid = left + (right - left)/2;
            if (canCap(weights,D,mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canCap(int[] weights, int d, int mid)
    {
        int sum = 0;
        int day = 0;
        for (int i = 0; i < weights.length; i++)
        {
            sum += weights[i];
            if (sum > mid){
                day ++;
                sum = weights[i];
            }
        }
        return d > day;//倒数第二个无论有没有day++，最后一个都还需要再++，所以d一定要严格大于day
    }
}
