package com.atguigu.note1_68;

import java.util.ArrayList;
import java.util.List;

public class NO57_2和为s的连续正整数序列 {
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 2;
        int sum = 3;
        List<int[]> list = new ArrayList<>();
        while (i <= target/2){
            if (sum < target){
                j ++;
                sum += j;
            }else if (sum > target){
                sum -= i;
                i ++;
            }else {
                int[] arr = new int[j - i + 1];
                int n = i;
                for (int k = 0; k < arr.length; k++) {
                    arr[k] = n ++;
                }
                list.add(arr);
                sum -= i;
                i ++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
