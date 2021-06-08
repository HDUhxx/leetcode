package com.atguigu.hot100;

import java.util.Arrays;

public class NO179最大数 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = "" + nums[i];
        }
        /*Arrays.sort(strings,(s1, s2) -> {
            String a = s1 + s2;
            String b = s2 + s1;
            return b.compareTo(a);
        });*/
        String[] temp = new String[strings.length];
//        rank(strings,0,nums.length - 1,temp);
        quick(strings,0,nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') k ++;
        return sb.substring(k);
    }

    //快排
    private void quick(String[] nums, int left, int right) {
        if (left >= right){
            return;
        }
        int l = left;
        int r = right;
        while (l < r){

        }
    }


    //归并排序
    private void rank(String[] nums, int left, int right, String[] temp) {
        if (left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        rank(nums,left,mid, temp);
        rank(nums,mid + 1,right, temp);
        merg(nums,left,mid,right,temp);
    }

    private void merg(String[] nums, int left, int mid, int right, String[] temp) {
        int l = left;
        int r = mid + 1;
        int k = 0;
        while (l <= mid && r <= right){
            String s1 = nums[l] + nums[r];
            String s2 = nums[r] + nums[l];
            if (s1.compareTo(s2) > 0){
                temp[k ++] = nums[l ++];
            }else {
                temp[k ++] = nums[r ++];
            }
        }
        while (l <= mid){
            temp[k ++] = nums[l ++];
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
