package com.atguigu.hot100;

public class NO289生命游戏 {
    public static void main(String[] args) {
//        String s = "[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]";
//        String replace = s.replace('[', '{');
//        String replace1 = replace.replace(']', '}');
//        System.out.println(replace1);
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
//        System.out.println(board.toString());
    }
    public static void gameOfLife(int[][] board) {
        int[] dx = {1,1,1,0,0,-1,-1,-1};
        int[] dy = {1,0,-1,1,-1,1,0,-1};
        if (board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length){
                        count += board[x][y] & 1;
                        //这里不可以判断是否等于1 ，倒数第二位可能有值
//                        if (board[i][j] == 1) count ++;
                    }
                }
                board[i][j] = board[i][j] & 1;

                if (board[i][j] == 1 && (count == 2 || count == 3)){
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
