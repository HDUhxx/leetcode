package com.atguigu.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class 子集78
{

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0){
            res.add(list);
            return res;
        }


        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums,0,path,res);
        return res;
    }

    private void dfs(int[] nums,int begin, ArrayList<Integer> path, List<List<Integer>> res)
    {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }else {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < nums.length; i++)
        {
            path.add(nums[i]);
            dfs(nums,i + 1,path,res);
            path.remove(path.size() - 1);
        }


    }
}
