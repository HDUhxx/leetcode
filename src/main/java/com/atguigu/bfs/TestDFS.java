package com.atguigu.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TestDFS
{
    public static void main(String[] args)
    {
        int sum = sum(155);
        System.out.println(sum);
    }


    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0 ) return 0;
        int count  = 0;
        boolean[][] visited = new boolean[m][n];
        return dfs2(0,0,m,n,k,visited);

    }

    private int dfs2(int i, int j,int m,int n, int k, boolean[][] visited)
    {
        if (i < 0 || j < 0 || i >= m || j >= n ){
            return 0;
        }
        if(sum(i) + sum(j) > k || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;

        int l = dfs2(i + 1,j,m,n,k,visited);
        int r = dfs2(i,j + 1,m,n,k,visited);

        return l + r + 1;

    }

    private static int sum(int i ){
        int res = 0;
        while (i != 0){
            res += i % 10;
            i /= 10;
        }
        return res;
    }

    /**
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false

     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (dfs1(board,i,j,chars,0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs1(char[][] board, int i, int j,char[] chars,int index)
    {
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != chars[index]) {
            return false;
        }

        if (index == chars.length - 1) return true;

        char c = board[i][j];
        board[i][j] = '.';
        boolean res = dfs1(board,i + 1,j,chars,index + 1)||
                dfs1(board,i - 1,j,chars,index + 1)||
                dfs1(board,i,j + 1,chars,index + 1)||
                dfs1(board,i,j - 1,chars,index + 1);
        board[i][j] = c;
        return  res;

    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int m = grid.length,n = grid[0].length;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1') {
                    res ++;
                    dfs(grid,i,j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j)
    {
        if (grid[i][j] == '0' || i >= grid.length || i < 0 || j < 0 ||j >= grid[0].length) {
            return;
        }

        grid[i][j] = '0';

        dfs(grid,i + 1,j);
        dfs(grid,i,j + 1);
        dfs(grid,i - 1,j);
        dfs(grid,i,j - 1);
    }

    public int numIslands1(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int res = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1){
                    res ++;
                    queue.add(new int[]{i,j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++)
                        {
                            int[] poll = queue.poll();
                            if (poll[0] >= 0 && poll[0] < grid.length && poll[1] >= 0 && poll[1] < grid.length && grid[poll[0]][poll[1]] == '1'){
                                grid[poll[0]][poll[1]] = 0;
                                queue.add(new int[]{poll[0] + 1,poll[1]});
                                queue.add(new int[]{poll[0] - 1,poll[1]});
                                queue.add(new int[]{poll[0],poll[1] + 1});
                                queue.add(new int[]{poll[0],poll[1] - 1});
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    public int numSquares(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        int count = 0;
        while (!queue.isEmpty()) {
            count ++;
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                Integer poll = queue.poll();
//                if (poll == 0) return count;
                for (int j = (int) Math.sqrt(poll); j > 1; j--)
                {
                    if (poll == j * j) return count;
                    queue.add(poll - j * j);
                }
            }
        }

        return n;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) return res;

        List<String> path = new ArrayList<>();
        dfs3(res,path,s,0);
        return res;
    }

    private void dfs3(List<List<String>> res, List<String> path, String s, int start)
    {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++)
        {
            if (isHuiwen(s,start,i)){
                path.add(s.substring(start,i + 1));
                dfs3(res,path,s,i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isHuiwen(String s, int start, int i)
    {
        int len = i - start + 1;
        if (len < 2) return true;

        while (start <= i) {
            if (s.charAt(start) != s.charAt(i)){
                return false;
            }
            start ++;
            i --;
        }
        return true;

    }

    public int maxAreaOfIsland1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length,n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1){
                    int r = dfs4(grid,i,j);
                    max = Math.max(max,r);
                }
            }
        }

        return max;
    }

    private int dfs4(int[][] grid, int i, int j)
    {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = 0;
        return dfs4(grid,i + 1,j)+
        dfs4(grid,i - 1,j)+
        dfs4(grid,i,j + 1)+
        dfs4(grid,i,j - 1) + 1;
    }

//    public int ma

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =  new ArrayList<>();
        if (root == null) return  res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode poll = q.poll();
                path.add(poll.val);
                if (poll.left != null){
                    q.add(poll.left);
                }
                if (poll.right != null){
                    q.add(poll.right);
                }
            }
            res.add(new ArrayList<>(path));
        }

        return res;
    }
}
