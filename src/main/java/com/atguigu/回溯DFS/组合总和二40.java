package com.atguigu.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class 组合总和二40
{


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();


        ArrayList<Integer> path = new ArrayList<>();
        dfs(candidates,0,target,path,res);
        return res;
    }

    private void dfs(int[] candidates,int begin, int target, ArrayList<Integer> path, List<List<Integer>> res)
    {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0){
            return;
        }

        for (int i = begin; i < candidates.length; i++)
        {

            if (i > begin && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            //对于begin的理解，因为每个数只能使用一次，所以从i+1继续dfs
            dfs(candidates,i + 1,target - candidates[i],path,res);
            path.remove(path.size() - 1);
        }
    }
}
