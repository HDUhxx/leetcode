package com.atguigu.回溯DFS;

import sun.security.provider.Sun;

import java.util.*;

public class Test2
{

    public  List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12){
            return res;
        }

        Deque<String> path = new ArrayDeque<>();
        dfs1(res,path,s,0,4);
        return res;
    }

    private void dfs1(List<String> res, Deque<String> path, String s, int begin, int last)
    {
        if (begin == s.length()){
            if (last == 0){
                res.add(String.join(".",path));
                return;
            }
        }

        for (int i = begin; i < begin + 3; i++)
        {
            if (i >= s.length()) break;
            if (last * 3 + i < s.length()) continue;
            if (isIP(s.substring(begin,i + 1))){
                path.add(s.substring(begin, i + 1));
                dfs1(res,path,s,i + 1,last - 1);
                path.removeLast();
            }
        }
    }

    private boolean isIP(String substring)
    {
        int len = substring.length();
        if (len > 1 && substring.charAt(0) == '0') return false;

        int res = 0;
        for (int i = 0; i < substring.length(); i++)
        {
            res = res * 10 + substring.charAt(i) - '0';
        }

        return res >= 0 && res <= 255;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0)return res;
        List<String> path = new ArrayList<>();
        dfs(res,path,s,0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, String s, int index)
    {
        if (index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++)
        {
            if (isHUI(s,index,i)){
                path.add(s.substring(index,i + 1));
                dfs(res,path,s,i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isHUI(String s, int index, int i)
    {
        int len = i - index + 1;
        if (len < 2) return true;
        while (index <= i){
            if (s.charAt(index) != s.charAt(i)){
                return false;
            }
            index ++;
            i --;
        }
        return true;
    }
}
