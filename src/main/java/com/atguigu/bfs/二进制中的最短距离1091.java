package com.atguigu.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 二进制中的最短距离1091
{
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1){
            return -1;
        }

        grid[0][0] = 1;
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,1,-1,1,-1,0};

        q.add(new int[]{0,0});

        int count = 0;
        while (!q.isEmpty()){
            count ++;
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                int[] poll = q.poll();
                if (poll[0] == m - 1 && poll[1] == n - 1){
                    return count;
                }
                for (int j = 0; j < 8; j++)
                {
                    int x1 = poll[0] + dx[j];
                    int y1 = poll[1] + dy[j];
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == 0){
                        q.add(new int[]{x1,y1});
                        grid[x1][y1] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
