package com.atguigu.bfs;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayDeque;
import java.util.Queue;

public class 被围绕的区域130
{

    //
    public void solve(char[][] board) {
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
                    dfs(board,i,j);

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

    private void dfs(char[][] board, int i, int j)
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


}
