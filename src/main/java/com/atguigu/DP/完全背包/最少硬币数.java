package com.atguigu.DP.完全背包;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 最少硬币数
{
    public static void main(String[] args)
    {

        /*double arr[] = {23.62,30.5,35.25,38.69,41.32,43.31,44,45.56,46.17,47.06,47.25,47.46,47.60,47.86,47.89,47.28,47.01,47.15,47.09,46.52,46.41,46.28};
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = arr[i] - arr[0];
            System.out.printf(arr[i]+",");
        }*/
        double arr[] = {0,5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80};
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = arr[i] * 1.4;
            System.out.printf(arr[i]+",");
        }
    }


    //bfs
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(amount);
        int count = 0;
        while (!q.isEmpty()){
            count ++;
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                int poll = q.poll();
                for (int j = 0; j < coins.length; j++)
                {
                    if (poll >= coins[j]){
                        int x = poll - coins[j];
                        if (x == 0){
                            return count;
                        }
                        q.add(x);
                    }
                }
            }
        }
        return -1;
    }







    //dp
    //NO.322
    public int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
