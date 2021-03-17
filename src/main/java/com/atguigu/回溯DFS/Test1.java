package com.atguigu.回溯DFS;

import java.lang.annotation.Target;
import java.nio.file.Path;
import java.util.*;

public class Test1
{





    private void dfs11(List<String> res, char[] chars, int i) {
        if (i == chars.length){
            res.add(new String(chars));
            return;
        }
        dfs11(res,chars,i + 1);
        if (Character.isLetter(chars[i])){
            chars[i] ^= 1 << 5;
            dfs11(res,chars,i + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() ==  0) return res;

        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder sb = new StringBuilder();
        back(map,res,sb,digits,0);
        return res;
    }

    private void back(Map<Character, String> map, List<String> res, StringBuilder sb, String digits, int index)
    {
        if (sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }


        char c = digits.charAt(index);
        String s = map.get(c);
        /*for (int i = 0; i < s.length(); i++)
        {
            sb.append(s.charAt(i));
            back(map,res,sb,digits,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }*/
        for (char c1 : s.toCharArray()){
            sb.append(c1);
            back(map,res,sb,digits,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0){
            return res;
        }

        List<Integer> path = new ArrayList<>();
        dfs10(res,path,n,k,1);
        return res;
    }

    private void dfs10(List<List<Integer>> res, List<Integer> path, int n, int k, int index)
    {
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < n + 1; i++)
        {
            path.add(i);
            dfs10(res,path,n,k,i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0){
            res.add(new ArrayList<>());
            return res;
        }

        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs9(res,path,nums,0);
        return res;
    }

    private void dfs9(List<List<Integer>> res, List<Integer> path, int[] nums, int index)
    {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }else {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; i++)
        {
            if (i > index && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            dfs9(res,path,nums,i + 1);
            path.remove(path.size() - 1);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0){
            res.add(list);
            return res;
        }

        List<Integer> path = new ArrayList<>();
        dfs8(res,path,0,nums);
        return res;
    }

    private void dfs8(List<List<Integer>> res, List<Integer> path, int index, int[] nums)
    {
        if (index == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }else {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; i++)
        {
            path.add(nums[i]);
            dfs8(res,path,i + 1,nums);
            path.remove(path.size() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        String path = "";
        dfs7(res,n,n,path);
        return res;
    }

    private void dfs7(List<String> res, int left, int right, String path)
    {
        if (left == 0 && right == 0) {
            res.add(path);
            return;
        }

        if (left >right)return;

        if (left > 0){
            path += "(";
            dfs7(res,left - 1,right,path);
        }
        if (right > 0){
            path += ")";
            dfs7(res,left,right - 1,path);
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S.length() == 0) return res;

        char[] chars = S.toCharArray();
        dfs6(res,chars,0);
        return res;
    }

    private void dfs6(List<String> res, char[] chars, int index)
    {
        if (index == chars.length){
            res.add(new String(chars));
            return;
        }

        dfs6(res,chars,index + 1);
        if (Character.isLetter(chars[index])){
            chars[index] ^= 1<<5 ;
            dfs6(res,chars,index + 1);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 ) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(res,path,nums,used);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums,boolean[] used)
    {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(res,path,nums,used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 ) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs1(res,nums,path,used);
        return res;
    }

    private void dfs1(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] used)
    {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (used[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]){
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dfs1(res,nums,path,used);
            used[i] =false;
            path.remove(path.size() - 1);
        }
    }

    /**
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) return res;
        List<Integer> path = new ArrayList<>();
        dfs2(res,path,candidates,target,0);
        return res;
    }

    private void dfs2(List<List<Integer>> res, List<Integer> path, int[] candidates, int target,int start)
    {
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++)
        {
            if (target >= candidates[i]){
                path.add(candidates[i]);
                dfs2(res,path,candidates,target - candidates[i],i + 1);
                path.remove(path.size() - 1);
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
            if(begin > 0 && candidates[i] == candidates[i - 1]){
                continue;
            }
            if (target >= candidates[i]){
                path.add(candidates[i]);
                dfs3(res,path,target - candidates[i],candidates,i + 1);
                path.remove(path.size() - 1);
            }
        }
    }


    /**
     *     输入: k = 3, n = 9
     *     输出: [[1,2,6], [1,3,5], [2,3,4]]
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (k == 0 || n == 0) return res;

        dfs4(res,path,k,n,1);
        return res;
    }

    private void dfs4(List<List<Integer>> res, List<Integer> path, int k, int n,int begin)
    {
        if (path.size() == k){
            if (n == 0){
                res.add(new ArrayList<>(path));
                return;
            }
            return;
        }

        for (int i = begin; i < 10; i++)
        {
            path.add(i);
            dfs4(res,path,k,n - i,i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs5(res,path,nums,0, 0);
        return res;
    }

    private void dfs5(List<List<Integer>> res, List<Integer> path, int[] nums, int begin, int target)
    {
        if (path.size() == 3 && target != 0) return;
        if (path.size() == 3 && target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < nums.length; i++)
        {
            if (i > begin && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            dfs5(res,path,nums,i + 1,target - nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
