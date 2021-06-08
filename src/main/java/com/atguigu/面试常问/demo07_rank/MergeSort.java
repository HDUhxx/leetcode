package com.atguigu.面试常问.demo07_rank;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergerSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序： 先分，后合并
     * @param nums
     * @return
     */
    public void  mergerSort(int[] nums){
        int[] temp = new int[nums.length];
        merg(nums,0,nums.length - 1,temp);

    }

    private void merg(int[] nums, int left, int right, int[] temp) {
        if (left >= right){
            return;
        }

        int mid = left + (right - left)/2;
        merg(nums,left,mid,temp);
        merg(nums,mid + 1,right,temp);
        bing(nums,left,mid,right,temp);
    }

    //合并的时候就变成了，合并两个有序数组
    private void bing(int[] nums, int left, int mid, int right, int[] temp) {
        int k = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right){
            if (nums[l] < nums[r]){
                temp[k ++] = nums[l];
                l ++;
            }else {
                temp[k ++] = nums[r];
                r ++;
            }
        }
        while (l <= mid){
            temp[k ++] = nums[l++];
        }
        while (r <= right){
            temp[k ++] = nums[r ++];
        }

        k = 0;
        while (left <= right){
            nums[left ++] = temp[k ++];
        }
    }
}
