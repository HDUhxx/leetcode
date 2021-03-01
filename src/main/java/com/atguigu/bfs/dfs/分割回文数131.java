package com.atguigu.bfs.dfs;

import java.util.ArrayList;
import java.util.List;

public class 分割回文数131
{


    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0){
            return res;
        }

        List<String> path  = new ArrayList<>();
        dfs(res,path,s,0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, String s,int start)
    {
        if (s.length() == start){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++)
        {
            if (!check(s,start,i)){
                continue;
            }

            path.add(s.substring(start,i + 1));
            dfs(res,path,s,i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean check(String str,int left,int right){
        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }

            left ++;
            right --;
        }
        return true;
    }
}
