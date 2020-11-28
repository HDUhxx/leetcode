package com.atguigu.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class 组合总和三216
{




    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k*(k+1)/2 > n){
            return res;
        }

        boolean[] used = new boolean[9];
        ArrayList<Integer> path = new ArrayList<>();

        dfs(k,0,n,used,path,res);

        return res;
    }

    private void dfs(int k, int begin,int n, boolean[] used, ArrayList<Integer> path, List<List<Integer>> res)
    {
        if (n != 0 && path.size() == k){
            return;
        }
        if (n == 0 && path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        //从begin开始按顺序搜索，避免集合中出现
        for (int i = begin; i < 9; i++)
        {
            if (!used[i]){
                used[i] = true;
                path.add(i + 1);
                dfs(k,begin + 1,n-i-1,used,path,res);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
