package com.atguigu.Tencent;

public class NO5最长回文字串
{
    //最长回文字串
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen){
                    begin = i;
                    maxLen = j-i+1;
                }

            }
        }

        return s.substring(begin,maxLen + begin);
    }
}
