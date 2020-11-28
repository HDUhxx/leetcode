package com.atguigu.rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的第K大的元素215
{

    /*在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
    而不是第 k 个不同的元素。*/
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKth(int[] nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });

        for (int num : nums){
            pq.add(num);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
        {
            res[i] = pq.poll();
        }

        return res[k - 1];
    }
}
