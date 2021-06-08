package com.atguigu.hot100;

public class NO134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare){
                minSpare = spare;
                index = i;
            }
        }

        return spare < 0 ? -1 : (index + 1)%gas.length;
    }
}
