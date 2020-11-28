package com.atguigu.BianryNoRecur;

public class 爱吃香蕉的珂珂
{
    public int minEatingSpeed(int[] piles, int H) {

//        int l = 0;
        int l = 1;
        int r = 0;
        for ( int p : piles){
            r = Math.max(r,p);
        }
        while (l < r){
            int mid = l + (r - l)/2;
            int h = 0;
            for (int i = 0; i < piles.length; i++)
            {
                if (piles[i] % mid == 0){
                    h += piles[i]/mid;//l不能从0开始，否则可能会除以0，不通过
                }else {
                    h += piles[i]/mid + 1;

                }
            }

            if (h <= H){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    
}
