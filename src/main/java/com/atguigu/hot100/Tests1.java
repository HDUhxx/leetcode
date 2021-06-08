package com.atguigu.hot100;

public class Tests1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) return 0;
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
