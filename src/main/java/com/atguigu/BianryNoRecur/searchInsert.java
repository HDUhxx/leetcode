package com.atguigu.BianryNoRecur;

//35题
public class searchInsert
{
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        if (len == 0) {
            return 0;
        }
        if(nums[len - 1] < target){
            return len;
        }
        //退出循环的时候l == r
        while(l < r){
            //选择中位数时向下取整（也就是最后两个的时候取左边的哪个）
            int mid = l + (r - l)/2;
            //下一轮的搜索空间[mid + 1,right]
            //最后2个的时候左边向右或者右边向左
            if(nums[mid] < target){
                l = mid + 1;
                //下一轮搜索空间为[left,mid]
            }else{
                r = mid;
            }
        }
        return l;
    }
}
