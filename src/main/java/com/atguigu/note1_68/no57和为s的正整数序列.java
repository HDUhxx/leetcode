package com.atguigu.note1_68;

import java.util.ArrayList;
import java.util.List;

public class no57和为s的正整数序列
{
    public int[][] findContinuousSequence(int target) {
        int i = 1,j = 2,s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j){
            if (s == target){
                int[] ans = new int[j - i + 1];
                for (int k = i ; k <= j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            if (s > target){
                i ++;
                s -= i;
            }
            if (s < target){
                j ++;
                s += j;
            }
        }

        return res.toArray(new int[0][]);
    }
}
