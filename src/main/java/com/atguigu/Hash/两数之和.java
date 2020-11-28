package com.atguigu.Hash;

import java.util.HashMap;
import java.util.Map;

public class 两数之和
{
    public static void main(String[] args)
    {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (hashmap.containsKey(target - nums[i])){
                return new int[]{hashmap.get(target - nums[i]),i};
            }
            hashmap.put(nums[i],i);
        }
        return new int[0];
    }
}
