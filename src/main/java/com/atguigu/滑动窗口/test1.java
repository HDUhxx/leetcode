package com.atguigu.滑动窗口;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

public class test1
{
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        //map维护有边界，
        //left是原有的left和重复元素+1中较大的
        for (int i = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i - left + 1);
        }
        return maxLen;
    }
}
