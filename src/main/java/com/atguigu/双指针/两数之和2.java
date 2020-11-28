package com.atguigu.双指针;

public class 两数之和2
{
    public static void main(String[] args)
    {

    }


    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j){
            if (numbers[i] + numbers[j] > target){
                j --;
            }
            else if (numbers[i] + numbers[j] < target)
            {
                i ++;
            }else {
                return new int[]{i + 1,j + 1};
            }
        }
        return new int[]{-1,1};
    }

    //暴力
    public int[] twoSum1(int[] numbers, int target) {
        int[] arr = new int[2];
        for (int i = 1; i < numbers.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (numbers[i] + numbers[j] == target){
                    arr[0] = j + 1;
                    arr[1] = i + 1;
                    break;
                }
            }
        }
        return arr;
    }
}
