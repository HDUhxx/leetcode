package com.atguigu.note1_68;

import java.util.*;

public class test2
{




    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        int [] res = new int[list.size()];
        int i = 0;
        while (!list.isEmpty()){
            res[i ++] = list.pollLast();
        }

        return res;
    }

    private ListNode reverse(ListNode head){
        if (head == null){
            return head;
        }

        ListNode temp = reverse(head.next);
        head.next.next = head;
        return temp;
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int m = 0,n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0){
            if (matrix[m][n] > target){
                n --;
            }else if (matrix[m][n] < target){
                m ++;
            }else {
                return true;
            }
        }

        return false;
    }

    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i])){
                return nums[i];
            }else {
                map.put(nums[i],1);
            }
        }
        return -1;
    }
    public int getIndex(String s ,int index){
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (map1.containsKey(c)){
                map1.put(c,i);
            }
        }
        return 0;
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        return dfs(s,0);
    }

    private int dfs(String s, int index)
    {
        if (index >= s.length() - 1){
            return 1;
        }

        int res = dfs(s,index + 1);
        String temp = s.substring(index,index + 2);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
            res += dfs(s,index + 2);
        }
        return res;
    }
}
