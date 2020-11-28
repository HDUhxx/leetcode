package com.atguigu.bfs;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class test
{
    /*public  boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int index)
    {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[index]){
            return false;
        }

        if (index == words.length - 1){
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '.';
        boolean res = dfs(board,words,i + 1,j,index + 1) ||
                dfs(board,words,i - 1,j,index + 1) ||
                dfs(board,words,i ,j + 1,index + 1) ||
                dfs(board,words,i,j - 1,index + 1);

        board[i][j] = temp;
        return res;
    }*/

    /*public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 ){
            return 0;
        }
        int[] dx = {1,1,1,0,0,-1,-1,-1};
        int[] dy = {-1,0,1,-1,1,1,0,-1};
        int m = grid.length,n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1){
            return -1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});

        int count = 0;
        while (!q.isEmpty()){
            count ++;
            for (int i = 0; i < q.size(); i++)
            {
                int[] poll = q.poll();
                if (poll[0] == m - 1 && poll[1] == n - 1){
                    return count;
                }
                for (int j = 0; j < 8; j++)
                {
                    int x = poll[0] + dx[j];
                    int y = poll[1] + dy[j];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[i][j] == 0){
                        q.add(new int[]{i,j});
                        grid[i][j] = 1;
                    }
                }

            }
        }
        return -1;
    }*/

    /*public static int numSquares(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        int count = 0;
        while (!queue.isEmpty()){
            count ++;

            int size = queue.size();
            for (int j = 0; j < size; j++)
            {
                int poll = queue.poll();

                for (int i = 1; i * i <= poll; i++){

                    if (poll - i*i == 0){
                        return count;
                    }
                    queue.add(poll - i * i);
                }
            }
        }
        return n;
    }*/


    /*public static   int movingCount(int m, int n, int k) {
        if (k == 0){
            return 1;
        }

        boolean[][] visited = new boolean[m][n];


        return dfs(m,n,0,0,k,visited);

    }

    private static int dfs(int m, int n, int i, int j, int k,boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || i%10 + i/10 + j%10 + j/10 > k || visited[i][j]){
            return 0;
        }


        visited[i][j] = true;

        return 1 + dfs(m,n,i + 1,j,k,visited) + dfs(m,n,i,j + 1,k,visited);
    }


    public static void main(String[] args)
    {
        int i = movingCount(1,2,1);
        System.out.println(i);
    }*/

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        if (s.length() == 0){
            return res;
        }

        dfs(res,path,0,s);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, int begin, String s)
    {
        if (begin == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < s.length(); i++)
        {
            if (isHuiwen(s,begin,i)){
                path.add(s.substring(begin,i + 1));
                dfs(res,path,i + 1,s);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isHuiwen(String s, int left, int right)
    {
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }


    @Test
    public void test1(){

        int[] nums = new int[70];
        nums[0] = 0;
        System.out.print(nums[0]+",");
        for (int i = 1; i < nums.length; i++)
        {
            nums[i] = nums[i - 1] + 2;
            System.out.print(nums[i]+",");
        }
    }
}
