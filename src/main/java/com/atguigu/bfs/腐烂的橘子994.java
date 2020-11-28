package com.atguigu.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class 腐烂的橘子994
{
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int curt = 0;
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }else if (grid[i][j] == 1){
                    curt ++;
                }
            }
        }

        while (!q.isEmpty()){
            count ++;
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                int[] poll = q.poll();

                for (int j = 0; j < 4; j++)
                {
                    int x = poll[0] + dx[j];
                    int y = poll[1] + dy[j];
                    if (x >= 0 && x < grid.length && y >=0 && y < grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        curt --;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
        if (curt > 0){
            return -1;
        }else {
            return count;
        }
    }
}
