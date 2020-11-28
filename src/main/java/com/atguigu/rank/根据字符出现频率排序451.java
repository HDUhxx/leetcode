package com.atguigu.rank;

import java.util.Comparator;
import java.util.HashMap;
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
}
