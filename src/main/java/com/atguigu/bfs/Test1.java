package com.atguigu.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test1
{

    public static void main(String[] args)
    {
//        List<String> strings = restoreIpAddresses("25525511135");
//        System.out.println(strings);

        boolean ip = isIP("255", 0, 2);
        System.out.println(ip);
    }

    /**
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) return  res;

        Deque<String> path = new ArrayDeque<>();
        dfs1(res,path,s,0,4);
        return res;
    }

    private static void dfs1(List<String> res, Deque<String> path, String s, int begin, int last)
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
            if (i >= s.length()) break;
            if (last * 3 + i < s.length()) continue;

            if (isIP(s,begin,i)){
                path.add(s.substring(begin,i + 1));
                dfs1(res,path,s,i + 1,last - 1);
                path.removeLast();
            }
        }
    }

    private static boolean isIP(String s, int begin, int i)
    {
        int len = i - begin + 1;
        if (len > 1 && s.charAt(begin) == '0'){
            return false;
        }

        int res = 0;
        while (begin <= i){
            res = res * 10 + s.charAt(begin++)-'0';
        }

        return res >= 0 && res <= 255;
    }


    /**
     * 输入: "aab"
     * 输出:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) return res;

        List<String> path = new ArrayList<>();
        dfs(res,path,s,0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, String s,int start)
    {
        if(start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++)
        {
            if (!check(s,start,i)) continue;

            //这里List使用的是头插法，所以，最后remove的是索引的最后一个
            path.add(s.substring(start,i + 1));
            dfs(res,path,s,start + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean check(String s, int start, int i)
    {
        while(start < i){
            if (s.charAt(start) != s.charAt(i)) {
                return false;
            }

            start ++;
            i --;
        }

        return true;
    }
}
