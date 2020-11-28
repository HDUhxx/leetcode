package com.atguigu.位运算;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 只出现一次的两个数字260
{
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Set<Integer> hashSet = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            if(!hashSet.add(nums[i])){
                hashSet.remove(nums[i]);
            }
        }
        Iterator<Integer> iterator = hashSet.iterator();
        res[0] = iterator.next();//利用iterator来遍历hashSet中的值
        res[1] = iterator.next();
        return res;
    }
}
