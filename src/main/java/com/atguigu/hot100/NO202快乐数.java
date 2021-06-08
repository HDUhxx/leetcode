package com.atguigu.hot100;

public class NO202快乐数 {

    public static void main(String[] args) {
        int numsquare = numsquare(19);
        System.out.println(numsquare);
    }
    public boolean isHappy(int n) {
        if (n == 1) return true;
        int fast = n;
        int slow = n;
        do {
            fast = numsquare(fast);
            fast = numsquare(fast);
            slow = numsquare(slow);
        }while (slow != fast);
        if (slow == 1){
            return true;
        }else {
            return false;
        }
    }

    private static int numsquare(int n){
        int res = 0;
        while (n != 0){
            res += (n%10) * (n%10);
            n/= 10;
        }
        return res;
    }
}
