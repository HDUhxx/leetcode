package com.atguigu.回溯DFS;

import java.util.*;

public class 三数之和
{
    public static void main(String[] args)
    {

    }

    //NO.15 使用回溯会超出时间限制
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3){
            return res;
        }

        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        boolean[] used  = new boolean[nums.length];
        dfs(nums,used,path,res);

        for(List arrayList : res){
            Collections.sort(arrayList);
        }

        HashSet<List<Integer>> hashSet = new HashSet<>(res);
        res.clear();
        res.addAll(hashSet);
        return res;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res)
    {
        if (path.size() == 3){
            int sum = 0;
            for (int i = 0; i < path.size(); i++)
            {
                sum += path.get(i);
            }
            if (sum == 0){
                res.add(new ArrayList<>(path));
                return;
            }else {
                return;
            }

        }

        for (int i = 0; i < nums.length; i++)
        {
            if (!used[i])
            {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
