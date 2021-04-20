package com.atguigu.hot100;

public class NO190颠倒二进制 {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public static void main(String[] args) {
        int[] z = {0,0,4,8,11,14,16,18,19,22,24,28,29,32,32,34,36,37,40,41,42,43,44,45,46,47,48,49,50,50,51,51,52,52,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53};
        int chushi = 90;
        for (int i = 0; i < z.length; i++) {
            chushi = 92;
            z[i] = z[i] + chushi;
            System.out.print(z[i] + ",");
        }
    }
}
