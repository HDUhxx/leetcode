package com.atguigu.rank;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 根据字符出现频率排序451
{
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
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
        StringBuilder sb = new StringBuilder(s.length());
        while (!pq.isEmpty()){
            Character poll = pq.poll();
            int i = map.get(poll);
            for (int j = 0; j < i; j++)
            {
                sb.append(poll);
            }
        }
        return sb.toString();
    }

    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }


        int[] res =  new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            if (map.get(nums[i]) == 2){
                res[0] = nums[i];
            }
            if (!map.containsKey(i + 1)){
                res[1] =  i + 1;
            }
        }

        return res;
    }
}
