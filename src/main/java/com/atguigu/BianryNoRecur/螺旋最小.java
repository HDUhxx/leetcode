package com.atguigu.BianryNoRecur;

public class 螺旋最小
{

    //NO.153
    public static int findMin(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;                /* 左闭右闭区间，如果用右开区间则不方便判断右值 */
        while (left < right) {                      /* 循环不变式，如果left == right，则循环结束 */
            int mid = left + (right - left) / 2;    /* 地板除，mid更靠近left */
            if (numbers[mid] > numbers[right]) {          /* 中值 > 右值，最小值在右半边，收缩左边界 */
                left = mid + 1;                     /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */
            } else if (numbers[mid] < numbers[right]) {   /* 明确中值 < 右值，最小值在左半边，收缩右边界 */
                right = mid;                        /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */
            }
        }
        return numbers[left];    /* 循环结束，left == right，最小值输出nums[left]或nums[right]均可 */
    }

    public static void main(String[] args)
    {
        int[] num = {1,3,5};
        int min = findMin(num);
        System.out.println(min);
    }
}
