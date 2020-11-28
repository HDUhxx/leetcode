package com.atguigu.bfs.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 复原ip地址93
{
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        if (s.length() > 12 || s.length() < 4){
            return res;
        }

        dfs(res,path,s,0,4);
        return res;
    }

    private static void dfs(List<String> res, Deque<String> path, String s, int begin, int last)
    {
        if (begin == s.length()){
            if (last == 0){
                res.add(String.join(".",path));
                return;
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++)
        {
            if (i >= s.length()){
                break;
            }

            if (last * 3 < s.length() -i){
                continue;
            }

            if (judgeIp(s,begin,i)){
                path.addLast(s.substring(begin,i + 1));
                dfs(res,path,s,i + 1,last - 1);
                path.removeLast();
            }
        }

    }

    private static   boolean judgeIp(String s, int l, int r) {
        int len = r - l + 1;
        if (len > 1 && s.charAt(l) == '0'){
            return false;
        }

        int res = 0;
        while (l <= r){
            res = res*10 + s.charAt(l) - '0';
            l ++;
        }

        return res <= 255 && res >= 0;
    }

    public static void main(String[] args)
    {
        List<String> strings = restoreIpAddresses("25525511135");
        System.out.println(strings);
    }


}
