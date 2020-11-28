package com.atguigu.bfs.dfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class 岛屿的最大面积695
{

    public static int maxAreaOfIsland(int[][] grid) {
        int maxAra = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1){
                    maxAra = Math.max(maxAra,dfs(grid,i,j));
                }
            }
        }
        return maxAra;
    }

    private static int dfs(int[][] grid, int i, int j)
    {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;
        return 1 + dfs(grid,i + 1,j) + dfs(grid,i - 1,j) + dfs(grid,i,j + 1) + dfs(grid,i,j - 1);
    }

    public static int maxAreaOfIsland1(int[][] grid) {

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1){
                    maxArea = Math.max(bfs(grid,i,j),maxArea);
                }
            }
        }
        return maxArea;
    }

    /**
     * bfs 的每一层都有个最大值，不方便比较，需要每次bfs时记录下最大值。
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private static int bfs(int[][] grid, int i, int j)
    {
        int m = grid.length,n = grid[0].length;
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{i,j});
        grid[i][j] = 0;

        int max = 1;
        while (!q.isEmpty()){
            int[] poll = q.poll();

            for (int k = 0; k < 4; k++)
            {
                int x = poll[0] + dx[k];
                int y = poll[1] + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                    q.add(new int[]{x,y});
                    grid[x][y] = 0;
                    max++;
                }
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int i = maxAreaOfIsland(grid);
        System.out.println(i);

    }
}
