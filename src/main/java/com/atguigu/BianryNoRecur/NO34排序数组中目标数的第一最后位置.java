package com.atguigu.BianryNoRecur;

public class NO34排序数组中目标数的第一最后位置 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        int l = 0,r = nums.length - 1;
        int[] res = new int[2];
        while (l < r ){//二分查找左边
            int mid = l + (r - l)/2;
            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) return new int[]{-1,-1};
        res[0] = l;
        r = nums.length - 1;
        while (l < r){//二分查找右边
            int mid = l + (r - l + 1)/2;//mid向上取整，
            if (nums[mid] == target){
                l = mid;
            }else if (nums[mid] > target){
                r = mid -1;
            }
        }
        res[1] = l;
        return res;
    }
}
