package com.atguigu.bfs;

import org.junit.Test;

import java.util.*;

public class test
{

    @Test
    public void test2(){

    }





    private void dfs1(List<List<String>> res, List<String> q, String s, int begin) {
        if (begin >= s.length()){
            res.add(new ArrayList<>(q));
            return;
        }
        for (int i = begin; i < s.length(); i++) {
            if (isHuiwenChuan(s,begin,i)){
                q.add(s.substring(begin,i + 1));
                dfs1(res,q,s,i + 1);
                q.remove(q.size() - 1);
            }

        }
    }

    private boolean isHuiwenChuan(String s ,int i ,int j){
        char[] chars = s.toCharArray();
        while (i <= j){
            if (chars[i] != chars[j]){
                return false;
            }
            i++;
            j --;
        }
        return true;
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O'){
                    q.add(new int[]{i,j});
                    bfs(board,q);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }else  if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    private void bfs(char[][] board, Queue<int[]> q) {
        while (!q.isEmpty()){
            for (int k = 0; k < q.size(); k++) {
                int[] poll = q.poll();
                int x = poll[0],y = poll[1];
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O'){
                    continue;
                }

                board[x][y] = '#';

                q.add(new int[]{x + 1,y});
                q.add(new int[]{x - 1,y});
                q.add(new int[]{x,y - 1});
                q.add(new int[]{x,y + 1});
            }
        }

    }

    public int maxDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[] point = null;
        boolean hasOcean = false;
        while (!q.isEmpty()){
            point = q.poll();
            for (int j = 0; j < 4; j++) {
                int x = point[0] + dx[j];
                int y = point[1] + dy[j];
                if (x >= grid.length || x < 0 || y < 0 || y >= grid[0].length || grid[x][y] != 0){
                    continue;
                }
                grid[x][y] = grid[point[0]][point[1]] + 1;
                hasOcean = true;
                q.add(new int[]{x,y});
            }
        }

        if (point == null || !hasOcean) return -1;
        return grid[point[0]][point[1]] - 1;
    }
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
