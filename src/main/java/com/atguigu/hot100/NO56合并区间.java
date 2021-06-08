package com.atguigu.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO56合并区间 {
    /**
     *  输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        int index = -1;
        for (int[] interval : intervals){
            if (index == -1 || interval[0] > res[index][1]){
                res[++ index] = interval;
            }else {
                res[index][1] = Math.max(res[index][1],interval[1]);
            }
        }
        return Arrays.copyOfRange(res,0,index + 1);

    }
}
