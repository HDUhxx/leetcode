package com.atguigu.BianryNoRecur;

import java.util.logging.Level;

public class Tests {

    public int shipWithinDays(int[] weights, int D) {
        int max = weights[0];
        int sum = weights[0];
        for (int i = 1; i < weights.length; i++) {
            max = Math.max(max,weights[i]);
            sum += weights[i];
        }
        int left = max;
        int right = sum;
        while (left < right){
            int mid = left + (right - left)/2;
            if (fit(weights,mid,D)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean fit(int[] weights, int mid, int d) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > mid){
                sum = weights[i];
                count ++;
            }
        }
        return d > count;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = piles[0];
        for (int i = 0; i < piles.length; i++) {
            maxPile = Math.max(maxPile,piles[i]);
        }

        int left = 1,right = maxPile;
        while (left < right){
            int mid = left + (right - left)/2;
            if (caneat(piles,mid,h)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean caneat(int[] piles, int mid, int h) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i]/mid;
            if (piles[i] % mid != 0){
                sum ++;
            }
        }
        return sum <= h;
    }
}
