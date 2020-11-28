package com.atguigu.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class 全排列
{

    /**     NO.46:不含重复数字的
     *      [1,2,3]的全排列
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * @param nums
     * @return
     */
    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(res,nums,path,used);
        return res;

    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> path,boolean[] used)
    {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(res,nums,path,used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        全排列 solution = new 全排列();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }


}
