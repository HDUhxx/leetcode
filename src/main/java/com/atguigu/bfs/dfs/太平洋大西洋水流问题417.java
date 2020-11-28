package com.atguigu.bfs.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 太平洋大西洋水流问题417
{
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> path = new ArrayDeque<>();
        if (matrix.length == 0 || matrix[0].length == 0){
            return res;
        }

        dfs(res,path,matrix,0,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, Queue<int[]> path, int[][] matrix, int i, int j)
    {

    }
}
