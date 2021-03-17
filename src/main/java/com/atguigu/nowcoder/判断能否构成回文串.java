package com.atguigu.nowcoder;

public class 判断能否构成回文串 {
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] arr = new int[128];
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i]]++;
        }
        int odd = 0;
        for (int i : arr){
            odd += i/2*2;//计算出字符偶数的个数
        }

        if (s.length() > odd + 1) {
            return false;
        }else {
            return true;
        }
    }
}
