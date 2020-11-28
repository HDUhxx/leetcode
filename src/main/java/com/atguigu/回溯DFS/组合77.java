package com.atguigu.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class 组合77
{


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0){
            return res;
        }

        ArrayList<Integer> path = new ArrayList<>();
        dfs(n,0,k,path,res);
        return res;
    }

    private void dfs(int n, int begin,int k, ArrayList<Integer> path, List<List<Integer>> res)
    {
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < n; i++)
        {
            path.add(i + 1);
            dfs(n,i + 1,k,path,res);
            path.remove(path.size() - 1);
        }
    }
}
