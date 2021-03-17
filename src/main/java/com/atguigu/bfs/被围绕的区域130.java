package com.atguigu.bfs;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayDeque;
import java.util.Queue;

public class 被围绕的区域130
{

    //
    public static void solve(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if (isEdge && board[i][j] == 'O'){

                    //从边界开始深度搜索'O',->'#'
                    //没有被搜索到的就是被包围的’O‘

//                    dfs(board,i,j);
//                    board[i][j] = '#';
                    q.add(new int[]{i,j});
                    bfs(board,i,j,q);

                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    private static void bfs(char[][] board, int i, int j, Queue<int[]> q)
    {
        while (!q.isEmpty()){
            for (int k = 0; k < q.size(); k++)
            {
                int[] poll = q.poll();
                int x = poll[0],y = poll[1];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O'){
                    continue;
                }
                board[poll[0]][poll[1]] = '#';

                q.add(new int[]{x + 1,y});
                q.add(new int[]{x - 1,y});
                q.add(new int[]{x,y + 1});
                q.add(new int[]{x,y - 1});
            }
        }
    }

    private static void dfs(char[][] board, int i, int j)
    {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }

        board[i][j] = '#';
        dfs(board,i + 1,j);
        dfs(board,i - 1,j);
        dfs(board,i,j + 1);
        dfs(board,i,j - 1);
    }


    private void bfs1(char[][] board,int i,int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});

    }


    public static void main(String[] args)
    {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','O','O','X'},{'X','O','X','X'}};
        solve(board);
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }
}
