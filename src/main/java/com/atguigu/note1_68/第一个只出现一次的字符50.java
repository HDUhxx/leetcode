package com.atguigu.note1_68;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 第一个只出现一次的字符50
{
    //再看看
    //法1：HashMap
    /*public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c,false);
            }else {
                map.put(c,true);
            }
        }


        for (char c : s.toCharArray()){
            if (map.get(c) == true){
                return c;
            }
        }
        return ' ';
    }*/

    public char firstUniqChar(String s) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            a[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++)
        {
            if (a[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }

        return ' ';
    }
}
