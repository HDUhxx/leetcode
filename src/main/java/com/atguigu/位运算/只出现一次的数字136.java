package com.atguigu.位运算;

import java.util.HashSet;
import java.util.Set;

public class 只出现一次的数字136
{
    public int singleNumber(int[] nums) {


        //利用了HashSet
        Set<Integer> hashSet = new HashSet<>();

        for(int i = 0;i < nums.length;i++){//
            if(!hashSet.add(nums[i])){//如果加入失败，说明有这个数了，
                hashSet.remove(nums[i]);//所以把这个数移除
            }
        }
        Object[] objects = hashSet.toArray();

        return  hashSet.iterator().next();//得到剩下的最后一个元素






        //利用了异或操作符的两个性质

        //1、所有数异或，可以交换顺序
        //2、相同数异或，结果位0
        //3、一个数和0异或，结果为这个数
//         int x = nums[0];
//         for(int i = 1;i < nums.length;i++){
//             x = x ^ nums[i];
//         }
//         return x;
    }
}
