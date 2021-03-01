package com.atguigu.双指针;

import java.util.Arrays;

public class 合并两个有序数组
{
    //88
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //法二
        // Make a copy of nums1.
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);


        /**
         *      * @param      src      the source array.
         *      * @param      srcPos   starting position in the source array.
         *      * @param      dest     the destination array.
         *      * @param      destPos  starting position in the destination data.
         *      * @param      length   the number of array elements to be copied.
         */
        //法一
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);


    }
}
