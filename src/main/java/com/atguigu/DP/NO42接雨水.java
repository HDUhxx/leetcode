package com.atguigu.DP;

public class NO42接雨水 {
    /**
     *  left_max[i] = max;
     *  right_max[i] = max;
     *  左右两边最大的重合部分
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int max = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max,height[i]);
            left_max[i] = max;
        }

        max = 0;
        for (int i = height.length - 1 ;i >= 0; i--) {
            max = Math.max(max,height[i]);
            right_max[i] = max;
        }
        for (int i = 0; i < height.length; i++) {
            res += Math.min(left_max[i],right_max[i]) - height[i];//重合部分减去height
        }
        return res;
    }
}
