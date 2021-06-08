package com.atguigu.hot100;

import java.util.*;

public class Tests {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,1,};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public String intToRoman(int num) {
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 13){
            while (num >= nums[index]){
                sb.append(strs[index]);
                num -= nums[index];
            }
            index ++;
        }
        return sb.toString();
    }

    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) <= map.get(s.charAt(i - 1))){
                res += s.charAt(i - 1);
            }else {
                res -= s.charAt(i - 1);
            }
        }
        res += s.charAt(s.length() - 1);
        return res;
    }


    public void gameOfLife(int[][] board) {
        Arrays.sort(board,(int[] a,int[] b) -> {
            return a[0] - b[0];
        });
        System.out.println(board.toString());
        if (board.length == 0 || board[0].length == 0) return;
        int[] dx = {1,1,1,0,0,-1,-1,-1};
        int[] dy = {1,0,-1,1,-1,1,0,-1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length){
                        count += board[x][y] & 1;
                    }
                }
                if ((board[i][j] & 1) == 1){
                    if (count == 2 || count == 3){
                        board[i][j] = 3;
                    }
                }
                if (board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0){
            return false;
        }
        if (n == 1) {
            return true;
        }
        return n%3 == 0 && isPowerOfThree(n/3);
    }
    /*public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : map1.keySet()){
            if (map2.get(i) != null){
                for (int j = 0; j < Math.min(map1.get(i), map2.get(i)); j++) {
                    list.add(i);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }*/

    public int titleToNumber(String columnTitle) {
        if (columnTitle.length() == 0) {
            return 0;
        }
        int res = 0;
        for (char c : columnTitle.toCharArray()){
            res = res * 26 + c-'A' + 1;
        }
        return res;
    }

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
