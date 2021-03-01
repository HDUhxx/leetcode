package com.atguigu.滑动窗口;

public class no567字符串的排列
{
    public boolean checkInclusion(String s1, String s2) {
        int  left = 0;
        int len = s1.length();
        for (int i = len - 1; i < s2.length(); i++)
        {
            String str = s2.substring(left,i + 1);
            if (isSame(str,s1)){
                return true;
            }
            left ++;
        }

        return false;
    }

    private boolean isSame(String str, String s1)
    {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++)
        {
            arr[str.charAt(i) - 'a'] ++;
            arr[s1.charAt(i) - 'a'] --;
        }

        for (int i = 0; i < str.length(); i++)
        {
            if (arr[str.charAt(i)] != 0){
                return false;
            }
        }
        return true;
    }
}
