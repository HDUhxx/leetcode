package com.atguigu.Tencent;

import java.util.Arrays;

public class NO26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length == 0 ? 0 : 1;
        int p = 0,q = 1;
        while (q < nums.length){
            if (nums[p] != nums[q]){
                nums[++p ] = nums[q];
            }
            q++;
        }
        return p + 1;
    }
}
