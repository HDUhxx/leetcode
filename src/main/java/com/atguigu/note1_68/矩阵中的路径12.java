package com.atguigu.note1_68;

import java.util.ArrayDeque;
import java.util.Queue;

public class 矩阵中的路径12 {

    Queue<int[]> q = new ArrayDeque<>();

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        if (board == null || board.length == 0 || board[0].length == 0){
            if (word == null){
                return true;
            }
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    q.add(new int[]{i,j});
                    if (dfs(board,i,j,0,words)){
                        return true;
                    }

                    if (bfs(board,i,j,0,words)){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, int i, int j, int depth, char[] word) {


        boolean res = false;
        while (!q.isEmpty()){

            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] poll = q.poll();
                int x = poll[0],y = poll[1];
                if (x >= board.length || x < 0 || y < 0 || y >= board[0].length || board[x][y] != word[depth]){
                    continue;
                }
                q.add(new int[]{x + 1,y});
                q.add(new int[]{x - 1,y});
                q.add(new int[]{x,y - 1});
                q.add(new int[]{x,y + 1});
                depth ++;
            }
            if (depth >= word.length){
                res = true;
                break;
            }
        }
        return res;

    }

    private boolean dfs(char[][] board, int i, int j ,int depth , char[] word) {
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != word[depth]){
            return false;
        }
        if (depth == word.length - 1){
            return true;
        }


        board[i][j] = '#';
        boolean res =  dfs(board,i + 1,j,depth + 1,word)||
        dfs(board,i - 1,j,depth + 1,word)||
        dfs(board,i,j + 1,depth + 1,word)||
        dfs(board,i,j - 1,depth + 1,word);
        board[i][j] = word[depth];
        return res;

    }
}
