package com.atguigu.回溯DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test
{
    /*public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0){
            return res;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(res,path,0,target,candidates);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> path, int begin, int target, int[] candidates)
    {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0){
            return;
        }

        for (int j = begin; j < candidates.length; j++)
        {
            if (j > begin && candidates[j] == candidates[j - 1]){
                continue;
            }
            if (target >= candidates[j]){
                path.add(candidates[j]);
                dfs(res,path,j,target - candidates[j],candidates);
                path.remove(path.size() - 1);
            }
        }
    }*/

    /*public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(res,path,0,k,n);
        return res;

    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int begin, int k, int n)
    {
        if (n == 0 && path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        if (n != 0 && path.size() == k){
            return;
        }

        for (int i = begin; i < n; i++)
        {
            path.add(i + 1);
            dfs(res,path,i + 1,k,n - i - 1 );
            path.remove(path.size() - 1);
        }
    }*/


    /*public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0,right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left)/2;

        }
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> path, int begin, int[] nums,int target)
    {
        if (path.size() == 3 && target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target != 0 && path.size() == 3){
            return;
        }

        for (int i = begin; i < nums.length; i++)
        {
            if (i > begin && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            dfs(res,path,i + 1,nums,target - nums[i]);
            path.remove(path.size() - 1);
        }
    }*/

    /*public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0){
            return res;
        }
        ArrayList<Integer> path = new ArrayList<>();

        dfs(res,path,n,k,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> path, int n, int k, int begin)
    {
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < n; i++)
        {
            path.add(i + 1);
            dfs(res,path,n,k,i + 1);
            path.remove(path.size() - 1);
        }
    }*/



    /*public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (nums.length == 0){
            return res;
        }

        Arrays.sort(nums);
        dfs(res,path,nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> path, int[] nums,int begin)
    {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        res.add(new ArrayList<>(path));

        for (int i = begin; i < nums.length; i++)
        {
            if (i > begin && nums[i] == nums[i - 1]){
                continue;
            }

            path.add(nums[i]);
            dfs(res,path,nums,i + 1);
            path.remove(path.size() - 1);
        }
    }*/


    /*public List<String> letterCasePermutation(String S) {
    List<String> res = new ArrayList<>();
    if (S.length() == 0){
        return res;
    }

    char[] chars = S.toCharArray();

    dfs(res,chars,0);
    return res;
}

    private void dfs(List<String> res, char[] chars, int index)
    {
        if (index == chars.length){
            res.add(new String(chars));
            return;
        }

        dfs(res,chars,index + 1);
        if(Character.isLetter(chars[index])){
            chars[index] ^= 1<<5;
            dfs(res,chars,index + 1);
        }
    }*/


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0){
            return res;
        }

        dfs(res,"",n,n);
        return res;
    }

    private void dfs(List<String> res,String s, int left ,int right)
    {
        if (left == 0 && right == 0){
            res.add(s);
            return;
        }

        if (left < right){
            return;
        }

        if (left > 0){
            dfs(res,s,left - 1,right);
        }

        if (right > 0){
            dfs(res,s,left,right - 1);
        }
    }

}
