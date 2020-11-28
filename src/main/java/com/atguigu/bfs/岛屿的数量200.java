package com.atguigu.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class 岛屿的数量200
{
    //dfs
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count ++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j)
    {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid,i + 1,j);
            dfs(grid,i - 1,j);
            dfs(grid,i,j + 1);
            dfs(grid,i,j - 1);
        }
    }


    /**     dfs bfs：一个岛屿一个岛屿的遍历，最后返回的就是岛屿的数量
     *
     *
     * @param grid
     * @return
     */
    public static int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        int m = grid.length,n = grid[0].length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, int i, int j)
    {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        while (!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1'){
                grid[x][y] = '0';
                q.add(new int[] { x + 1, y });
                q.add(new int[] { x - 1, y });
                q.add(new int[] { x, y + 1 });
                q.add(new int[] { x, y - 1 });

            }
        }
    }

    public static void main(String[] args)
    {
        char[][] arr = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        int i = numIslands(arr);
        System.out.println(i);
    }
}
