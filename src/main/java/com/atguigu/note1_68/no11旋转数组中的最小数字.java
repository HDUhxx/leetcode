package com.atguigu.note1_68;

public class no11旋转数组中的最小数字 {

    /**
     *[4,5,1,2,3]
     * 如果是没有发生旋转？[1,2,3]
     * 所以要和右边的比较
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]){
                left = mid + 1;//可以
                //left = mid ++;//不通过
            }else if (numbers[mid] < numbers[right]){
                right = mid;
            }else {
                right --;//对于重复的数字
            }
        }
        return numbers[left];
    }
}
