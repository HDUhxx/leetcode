package com.atguigu.note1_68;

import java.util.HashSet;
import java.util.Set;

public class no61扑克牌中的顺子 {
    /**
     *  为顺子的条件： 1、除了0，没有重复的
     *                2、最大值 - 最小值 < 5
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14,max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
            if (set.contains(nums[i])) return false;
            set.add(nums[i]);
        }
        return max - min < 5;
    }
}
