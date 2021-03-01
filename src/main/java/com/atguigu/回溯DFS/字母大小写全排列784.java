package com.atguigu.回溯DFS;


import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class 字母大小写全排列784
{
    public static void main(String[] args)
    {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'A');
        System.out.println((int) 'Z');

    }

    public List<String> letterCasePermutation(String S) {
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
        if(Character.isLetter(chars[index])){//判断某个字符是不是字母
            chars[index] ^= 1<<5;//大小写字母之间转换
            dfs(res,chars,index + 1);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length,n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                max = Math.max(max,dfs1(grid,i,j));
            }
        }
        return max;
    }

    private int dfs1(int[][] grid,int i ,int j){
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = 0;
        return dfs1(grid,i + 1,j) + dfs1(grid,i - 1,j) + dfs1(grid,i,j + 1) + dfs1(grid,i,j - 1) + 1;
    }


}
