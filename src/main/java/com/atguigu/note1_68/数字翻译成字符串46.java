package com.atguigu.note1_68;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class 数字翻译成字符串46
{
    public int translateNum(int num) {
        String s = String.valueOf(num);
        return dfs(s,0);
    }

    private int dfs(String s, int begin)
    {
        if (begin >= s.length() - 1){
            return 1;
        }

        int res = dfs(s,begin + 1);
        String temp = s.substring(begin,begin + 2);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
            res += dfs(s,begin + 2);
        }

        return res;
    }

    public int translateNum1(int num) {
        String s = num+"";

        int[] dp = new int[s.length() + 1];

        dp[0] = 0;
        dp[1] = 1;
          for (int i = 2; i < dp.length; i++)
        {
            String temp = s.substring(i-2,i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[s.length()];


    }

    public static void main(String[] args)
    {
        String s = 12+"";
        String s1 = s.substring(0,2);
        System.out.println(s1);
    }
}
