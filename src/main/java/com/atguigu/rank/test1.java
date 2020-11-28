package com.atguigu.rank;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class test1
{
    /*public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++)
        {
            pq.add(arr[i]);
        }

        int[] res = new int[k];
//        int i = 0;
        for (int j = 0; j < k; j++)
        {
            res[j] = pq.poll();
        }
        return res;
    }*/

    public int[][] kClosest(int[][] points, int K) {
        HashMap<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++)
        {
            map.put(points[i],points[i][0] * points[i][0] + points[i][1] * points[i][1]);

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return map.get(o1) - map.get(o2);
            }
        });

        pq.addAll(map.keySet());
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++)
        {
            int[] poll = pq.poll();
            res[i] = poll;
        }
        return res;
    }
}
