package com.atguigu.Tencent;

public class no11接雨水 {
    public int maxArea(int[] height) {
        int left = 0,right = height.length - 1,res = 0;
        while (left < right){
            res = height[left] < height[right] ?
                    Math.max(res,(right - left) * height[left ++]):
                    Math.max(res,(right - left) * height[right --]);
        }
        return res;
    }
}
