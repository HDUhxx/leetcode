package com.atguigu.rank;

import java.util.*;

public class 前K个高频元素347
{
    public static void main(String[] args)
    {
        int[] nums = {1,1,1,2,2,3};
        int[] ints = topKFrequent2(nums, 2);
        for (int i : ints){
            System.out.print(i + ",");
        }
    }
    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //建立优先队列（小根堆）通过Comparator自定义排序的算法
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            {
                return map.get(a) - map.get(b);
            }
        });

        for(Integer key:map.keySet()){
            if (queue.size() < k){//如果队列的规模小于k。直接入队
                queue.add(key);
            }else if (map.get(key) > map.get(queue.peek())){//否则与队列中频次最小的进行比较
                queue.poll();//若队列中频次最小的数字比该数字的频次小，则将其出队，将当前数字入队
                queue.add(key);
            }
        }

        int i = 0;
        while (!queue.isEmpty()){
            res[i ++] = queue.poll();
        }
        return res;
    }

    //桶
    public int[] topKFrequent(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] lists = new List[nums.length + 1];//用list作为桶
        for (int num : map.keySet())
        {//将数字的频次i作为桶的索引
            int i = map.get(num);
            if (lists[i] == null)
            {
                lists[i] = new ArrayList<>();
            }
            lists[i].add(num);//将频次为i的数字num放到桶中
        }

        int i = 0;
        int[] res = new int[k];
        for (int t = nums.length; t > 0; t--)
        {
            if (lists[t] != null)
            {
                for (int j = 0; j < lists[t].size() && i < k; j++)
                {
                    res[i++] = lists[t].get(j);
                }
            }

        }
        return res;
    }
}
