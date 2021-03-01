package com.atguigu.bfs;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayDeque;
import java.util.Queue;

public class 单词搜索79
{


    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                //从（i，j）这个坐标开始查询
                if (dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j,int index)
    {
        //终止条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[index]){
            return false;
        }

        if (index == words.length - 1){
            return true;
        }

        //因为不能往回找，所以把当前点置为’。‘，
        //dfs之后再变回来
        char temp = board[i][j];
        board[i][j] = '.';
        boolean res =   dfs(board,words,i + 1,j,index + 1) ||
                        dfs(board,words,i - 1,j,index + 1) ||
                        dfs(board,words,i ,j + 1,index + 1) ||
                        dfs(board,words,i,j - 1,index + 1);
        board[i][j] = temp;
        return res;
    }
}

//        char[] chars = word.toCharArray();
//        Queue<int[]> q = new ArrayDeque<>();
//        int[] dx = {1,0,0,-1};
//        int[] dy = {0,1,-1,0};
//        for (int i = 0; i < board.length; i++)
//        {
//            for (int j = 0; j < board[0].length; j++)
//            {
//                if (board[i][j] == chars[0]){
//                    q.add(new int[]{i,j});
//                }
//            }
//        }
//        int count = 0;
//
//        while (!q.isEmpty()){
//            count ++;
//            int size = q.size();
//            for (int i = 0; i < size; i++)
//            {
//                int[] poll = q.poll();
//                for (int j = 0; j < 4; j++)
//                {
//                    int x1 = poll[0] + dx[0];
//                    int y1 = poll[1] + dy[1];
//                    if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length && board[x1][y1] == chars[count]){
//                        q.add(new int[]{x1,y1});
//
//                    }
//                }
//            }
//        }
//
//        if (count == chars.length){
//            return true;
//        }else {
//            return false;
//        }
