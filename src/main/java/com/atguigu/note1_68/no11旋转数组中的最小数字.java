package com.atguigu.note1_68;

public class no11旋转数组中的最小数字 {

    /**
     *[4,5,1,2,3]
     * 如果是没有发生旋转？[1,2,3]
     * 所以要和右边的比较
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        if (numbers[right] > numbers[left]){
            return numbers[left];
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]){
                left = mid + 1;//可以
                //left = mid ++;//不通过
            }else if (numbers[mid] < numbers[right]){
                right = mid;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,0,1};
        int i = minArray(arr);

    }
}
