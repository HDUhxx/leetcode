package com.atguigu.rank;

import java.util.*;

public class test1
{

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return map.get(o2) - map.get(o1);
            }
        });

        for (int key : map.keySet()){
            q.add(key);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
        {
            res[i] = q.poll();
        }

        return res;
    }
    public int findKthLargest(int[] nums, int k) {
        //小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1 - o2;
            }
        });

        for (int n : nums){
            if (pq.size() < k){
                pq.add(n);
            }else if (n > pq.peek()){
                pq.poll();
                pq.add(n);
            }
        }

        return pq.peek();
    }


    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length,n = matrix[0].length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (priorityQueue.size() < k){
                    priorityQueue.add(matrix[i][j]);
                }else if (matrix[i][j] < priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.add(matrix[i][j]);
                }
            }
        }

        return priorityQueue.peek();
    }

    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>()
        {
            @Override
            public int compare(Character o1, Character o2)
            {
                return map.get(o2) - map.get(o1);
            }
        });

        for (Character c : map.keySet()){
            pq.add(c);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!pq.isEmpty()){
            Character poll = pq.poll();
            for (int i = 0; i < map.get(poll); i++)
            {
                stringBuilder.append(poll);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args)
    {

        String s = "tree";
        String s1 = frequencySort(s);
        System.out.println(s1);

    }
}
