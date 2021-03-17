package com.atguigu.nowcoder;

public class NO55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k= Math.max(k,i + nums[i]);
        }

        return true;
    }
}
