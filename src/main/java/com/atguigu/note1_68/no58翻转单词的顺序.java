package com.atguigu.note1_68;

public class no58翻转单词的顺序
{
    /*public String reverseWords(String s) {

    }*/

    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        n = n%length;
        String s1 = s.substring(0,n);
        String s2 = s.substring(n,s.length());

        return s2 + s1;
    }
}
