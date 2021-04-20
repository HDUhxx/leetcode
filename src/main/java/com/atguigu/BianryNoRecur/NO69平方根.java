package com.atguigu.BianryNoRecur;

public class NO69平方根 {
    /**
     *      sprt(x)
     * @param x
     * @return
     */
    public int mySqrt(int x) {
//        return (int) Math.sqrt(x);
        if (x == 0) return 0;
        int left = 1;
        int right = x/2;
        while (left < right){
            int mid = left + (right - left + 1)/2;
            if (mid > x/mid) {
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return left;
    }
}
