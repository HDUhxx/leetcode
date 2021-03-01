package com.atguigu.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 机器人的运动范围offer13
{
    public  int movingCount(int m, int n, int k) {
        /*//bfs
        if(k == 0){
            return 1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});

        int count = 1;
        while (!q.isEmpty()){
            for (int i = 0; i < q.size(); i++)
            {
                int[] poll = q.poll();
                int a = poll[0]%10 + poll[0]/10;
                int b = poll[1]%10 + poll[1]/10;

                if (a + b < k && poll[0] < m){
                    q.add(new int[]{poll[0] + 1,poll[1]});
                    count ++;
                }

                if (a + b < k && poll[1] < n){
                    q.add(new int[]{poll[0],poll[1] + 1});
                    count ++;
                }
            }
        }
        return count;*/

        //dfs
        //因为只会向右向下深度遍历，所以，只需要visited就好
        //但是，No79，不是，搜索过后可能还会遍历到这个点，所以不能直接搞个visited来记录，
        //                                          应该在深度之前temp代替，之后再改回来。
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,m,n,k,visited);

    }

    private  int dfs(int i, int j ,int m, int n, int k ,boolean[][] visited)
    {
        if (i < 0 || i >= m || j < 0 || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]){
            return 0;
        }

        visited[i][j] = true;
        return dfs(i + 1,j,m,n,k,visited) + dfs(i,j + 1,m,n,k,visited) + 1;
    }

  /*  public static void main(String[] args)
    {
        int i = movingCount(1, 2, 1);
        System.out.println(i);
    }*/
}
