package com.atguigu.hot100;

import java.nio.file.Path;
import java.util.*;

import static org.apache.commons.lang3.ArrayUtils.reverse;

public class Tests {


    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        int left = 0,right = s1.length - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("")) continue;
            sb.append(s1[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        myReverse(nums,0,nums.length - 1);
        myReverse(nums,0,k - 1);
        myReverse(nums,k,nums.length - 1);
    }

    private void myReverse(int[] nums, int left, int right) {
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (int i : map.keySet()){
            pq.add(i);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        //放进map
        for (char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()){
            pq.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            char ch = pq.poll();
            for (int j = 0; j < map.get(ch); j++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }
        return res;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] ++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
