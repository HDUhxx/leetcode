package com.atguigu.双指针;

import java.util.HashSet;
import java.util.Set;

public class 反转元音字母
{
    public static void main(String[] args)
    {

    }
/*
    public String reverseVowels(String s) {
        int [] arr = {'a','e','i','o','u'};
        int i = 0,j = s.length() - 1;
        while (i < j){
        }
    }*/

    //345
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r){
            while (!set.contains(chars[l]) && l < r){
                l ++;
            }
            while (!set.contains(chars[r]) && l < r){
                r --;
            }
            swap(chars,l,r);
            l ++;
            r --;
        }
        return new String(chars);
    }

    private void swap(char[] chars,int l ,int r){
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }
}
