package com.atguigu.note1_68;

import java.util.Arrays;

public class 把数组排成最小的数45
{
    //未通过
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        Arrays.sort(nums);
        str[0] = String.valueOf(nums[0]);
        for (int i = 1; i < nums.length; i++)
        {
            String a = str[i - 1] + nums[i];
            String b = nums[i] + str[i - 1];
            long min = Math.min(value(a), value(b));
            str[i] = min == value(a) ? a:b;
        }

        return str[nums.length - 1];
    }
    private long value(String a){
        long x = a.charAt(0) - '0';
        for (int i = 1; i < a.length(); i++)
        {
            int y = (a.charAt(i) - '0');

            x = x * 10 + y;

        }

        return x;
    }

    public static void main(String[] args)
    {
        把数组排成最小的数45 hh = new 把数组排成最小的数45();
        int[] nums = {128,12,320,32};
        String s = hh.minNumber(nums);
        System.out.println(s);
        long x = 3212128320L;
//        System.out.println(Integer.valueOf('0'));
//        System.out.println(Integer.valueOf('8'));
//        System.out.println(Integer.valueOf('9'));

    }
}
