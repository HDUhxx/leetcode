package com.atguigu.note1_68;

public class no66构建乘积数组
{
    public static int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int temp = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }

        return b;
    }

    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 4, 5};
        int[] ints = constructArr(a);
        System.out.println(ints);
    }
}
