package com.atguigu.DP.最长增长子序列;

public class 摆动序列376
{
    public static void main(String[] args)
    {

    }

    //376。摆动序列
    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        int up = 1;//下降到上升阶段就     + 1
        int down = 1;//上升到下降        + 1

        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > nums[i - 1]){
                up = down + 1;
            }else if (nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }

        return Math.max(up,down);
    }
}
