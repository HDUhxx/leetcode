package com.atguigu.双指针;

import java.util.Arrays;

public class test
{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1,0,nums1Copy,0,m);
        while (p1 < nums1Copy.length && p2 < nums2.length){
            nums1[p++] = nums1Copy[p1] > nums2[p2] ? nums2[p2 ++] : nums1Copy[p1 ++];
        }

        if (p1 < m){
            System.arraycopy(nums1Copy,p1,nums1,p,m + n -p);
        }
        if (p2 < n){
            System.arraycopy(nums2,p2,nums1,p,m + n - p);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1){
            return new int[0];
        }


        int left = 0;
        int right = nums.length - 1;

        int sum = 0;
        while (left < right){
            sum = nums[left] + nums[right];
            if (sum > target){
                right--;
            }else if (sum < target){
                left ++;
            }else {
                return new int[]{left,right};
            }
        }

        return new int[]{-1,1};
    }


    public static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) (Math.sqrt(c) + 1);
        while (left <= right){
            if (left * left + right * right > c){
                right --;
            }else if (left * left + right * right < c){
                left ++;
            }else {
                return true;
            }
        }
        return false;
    }
}
