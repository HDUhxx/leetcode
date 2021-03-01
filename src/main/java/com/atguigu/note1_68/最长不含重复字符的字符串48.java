package com.atguigu.note1_68;

import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的字符串48
{
    public int lengthOfLongestSubstring1(String s) {
        if(s.length() == 0) return 0;
        int left = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i ++) {
            if(map.containsKey(s.charAt(i))) {

                //示例：abba
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
    if (s.length() == 0){
        return 0;
    }

    int[] dp = new int[s.length() + 1];

    dp[0] = 0;
    dp[1] = 1;
    int max = 1;
    for (int i = 2; i < dp.length; i++)
    {
        if (!haveSame(s,dp[i - 1],i - 1)){
            dp[i] = dp[i - 1] + 1;
        }else {
            dp[i] = 1;
        }
        max = Math.max(dp[i],max);

    }
    return max;
}

    private static boolean haveSame(String s, int x, int i)
    {
        String str = s.substring(i-x,i);
        for(char c : str.toCharArray()){
            if (c == s.charAt(i)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        String s = "dvdf";
//        boolean b = haveSame(s, 2, 3);
//        System.out.println(b);
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
