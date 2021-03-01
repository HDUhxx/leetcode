package com.atguigu.DP.零一背包;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class 完全平方数
{
    public static void main(String[] args)
    {

    }

    //bfs
    public static int numSquares(int n) {
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
                        return count;//在每一层，减了之后，为0就return，否则就count多++了
                    }
                    queue.add(poll - i * i);
                }
            }
        }
        return n;
    }

    //再想想
    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++)
        {
            dp[i] = n;
            for (int j = 1; j * j <= i; j++)
            {
            dp[i] = Math.min(dp[i - j*j] + 1,dp[i]);
            }
        }
        return dp[n];
    }
}
