package com.atguigu.滑动窗口;

import com.atguigu.DP.股票.MaxProfit1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 无重复字符的最长子串3
{

    public int lengthOfLongestSubstring(String s) {

        /*if (s.length() == 0){
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;
*/
        if (s.length() == 0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i))){
                //abba,到最后的a的时候，left -> 索引3，
                //应该是，left与之前重复的未知 +1，中较大的。
                left = Math.max(left,map.get(s.charAt(i)) + 1);
//                left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }

        return max;
    }
}
