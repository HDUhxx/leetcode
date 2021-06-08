package com.atguigu.hot100;

import java.util.HashMap;
import java.util.Map;

public class NO395至少k个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for (char c : map.keySet()){
            if (map.get(c) < k){
                int res = 0;
                for (String t : s.split(String.valueOf(c))){
                    res = Math.max(res,longestSubstring(t,k));
                }
                return res;
            }
        }
        return s.length();
    }
}
