package com.atguigu.hot100;

public class NO162寻找峰值 {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] < nums[mid - 1]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] arr = {94,94,98,102,105,108,110,112,113,116,118,122,123,126,126,128,130,131,134,135,136,137,138,139,140,141,142,143,144,144,145,145,146,146,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147};
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= 94;
            System.out.print(arr[i] + ",");
        }
    }
}
