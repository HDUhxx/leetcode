package com.atguigu.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 地图分析海路距离1162
{

    //多元bfs，最后被访问到的海就是距离最远的，并且一定是被离他最近的海搜索到的
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int [][] dir = {{1,0},{0,1},{0,-1},{-1,0}};

        int m = grid.length,n = grid[0].length;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                //多源bfs
                if (grid[i][j] == 1){
                    q.add(new int[]{i,j});
                }
            }
        }

        int count = 0;
        while (!q.isEmpty()){
            count ++;
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                int[] poll = q.poll();


                for (int [] d : dir){
                    int x1 = poll[0] + d[0];
                    int y1 = poll[1] + d[1];
                    if (x1 >= 0 && x1 <m && y1 >= 0 && y1 < n && grid[x1][y1] == 0){
                        q.add(new int[]{x1,y1});
                        grid[x1][y1] = grid[poll[0]][poll[1]] + 1;
                    }
                }
            }
        }
        return count;
    }
}
