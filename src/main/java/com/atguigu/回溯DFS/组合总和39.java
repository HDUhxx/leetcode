package com.atguigu.回溯DFS;

import javafx.scene.Camera;

import java.util.*;

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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) return res;
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs3(res,path,target,candidates,0);
        return res;
    }

    private void dfs3(List<List<Integer>> res, List<Integer> path, int target, int[] candidates, int begin)
    {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++)
        {
            if(i > 0 && candidates[i] == candidates[i - 1]){
                continue;
            }
            if (target >= candidates[i]){
                path.add(candidates[i]);
                dfs3(res,path,target - candidates[i],candidates,i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
