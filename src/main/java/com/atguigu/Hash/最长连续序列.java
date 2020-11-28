package com.atguigu.Hash;

import java.util.HashMap;
import java.util.Map;

public class 最长连续序列
{


    /**
     *      128；最长连续序列
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int num : nums){
            if (!map.containsKey(num)){
                int l = map.get(num - 1) == null ? 0:map.get(num - 1);
                int r = map.get(num + 1) == null ? 0: map.get(num + 1);
                int cur = l + r + 1;
                if (cur > res){
                    res = cur;
                }
                map.put(num,cur);
                map.put(num - l,cur);
                map.put(num + r,cur);
            }
        }
        return res;
    }
}
