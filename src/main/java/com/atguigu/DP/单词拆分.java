package com.atguigu.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词拆分
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        String s = "leetcode";
        boolean b = wordBreak(s, list);
        System.out.println(b);
    }
    // DP
    public static boolean wordBreak(String s, List<String> wordDict) {
        int maxWordLength = 0;
        Set<String> wordSet = new HashSet<>(wordDict.size());
        for (String word : wordDict) {
            wordSet.add(word);

            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = (i - maxWordLength < 0 ? 0 : i - maxWordLength); j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }


}

