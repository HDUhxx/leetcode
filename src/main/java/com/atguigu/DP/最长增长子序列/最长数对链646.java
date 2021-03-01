package com.atguigu.DP.最长增长子序列;

import java.util.Arrays;
import java.util.Comparator;

public class 最长数对链646
{
    public static void main(String[] args)
    {
        int[][] matrix = {{0, 30}, {15, 20}, {5, 10}, {-10, 20}};
        //排序
        Arrays.sort(matrix, (a, b) -> a[0] - b[0]);
        //打印结果
        for (int[] arr : matrix) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }


    public static int findLongestChain(int[][] pairs) {
        if (pairs.length == 0){
            return 0;
        }
        int dp[] = new int[pairs.length];//dp[i]表示以pairs[i]结尾的最长数对链
//        Arrays.sort(pairs, new Comparator<int[]>()
//        {
//            @Override
//            public int compare(int[] o1, int[] o2)
//            {
//                return o1[0] - o2[0];
//            }
//        });

        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++)
        {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }

        int res = 0;

        for(int d : dp){
            if (d > res){
                res = d;
            }
        }

        return res;
    }


}
