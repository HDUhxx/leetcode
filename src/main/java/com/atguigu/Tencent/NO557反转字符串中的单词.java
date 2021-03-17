package com.atguigu.Tencent;

public class NO557反转字符串中的单词 {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            for (int j = strs[i].length() - 1; j >= 0 ; j--) {
                sb.append(strs[i].charAt(j));
            }
            sb.append(' ');
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
