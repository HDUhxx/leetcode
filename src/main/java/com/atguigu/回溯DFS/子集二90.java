package com.atguigu.回溯DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集二90
{



    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        if (nums.length == 0){
            res.add(list);
            return res;
        }
        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums,0,path,res);
        return res;
    }

    private void dfs(int[] nums, int begin, ArrayList<Integer> path, List<List<Integer>> res)
    {
        if (path.size() == nums.length ){
            res.add(new ArrayList<>(path));
            return;
        }else {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < nums.length; i++)
        {
            if ( i > 0 && nums[i] == nums[i - 1] ){
                continue;
            }
            path.add(nums[i]);
            dfs(nums,i + 1,path,res);
            path.remove(path.size() - 1);
        }
    }

}
