package com.atguigu.hot100;

import java.util.Arrays;

//NO384 打乱数组 公平的洗牌策略
public class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        Arrays.sort(this.nums);
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        return nums;
    }
}
