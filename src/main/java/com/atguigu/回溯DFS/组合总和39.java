package com.atguigu.回溯DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 组合总和39
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(target == 0){
            return res;
        }

        //ArrayDeque作为栈来使用
        Deque<Integer> path = new ArrayDeque<>();

        dfs(candidates,0,target,path,res);
        return res;
    }

    public void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0){
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target >= candidates[i]){
                path.addLast(candidates[i]);
                //dfs从i开始
                dfs(candidates,i,target - candidates[i],path,res);
                path.removeLast();
            }
        }
    }
}
