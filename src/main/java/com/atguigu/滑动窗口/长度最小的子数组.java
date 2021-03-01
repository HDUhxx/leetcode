package com.atguigu.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 长度最小的子数组
{
    //209
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++)
        {
            sum += nums[right];
            while (sum >= s){
                minLen = Math.min(minLen,right - left + 1);
                sum -= nums[left];
                left ++;
            }
        }

        if (minLen == Integer.MAX_VALUE){
            return 0;
        }

        return minLen;
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        if (s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,s.charAt(i) + 1);
            }
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i - left + 1);
        }
        return maxLen;
    }
}
