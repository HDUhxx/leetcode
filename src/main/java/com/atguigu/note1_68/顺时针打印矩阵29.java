package com.atguigu.note1_68;


public class 顺时针打印矩阵29
{
    //再看看
    public static int[] spiralOrder(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }

        int top = 0,left = 0;
        int bottom = matrix.length - 1,right = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int k = 0;

        while (top <= bottom && left <= right){
            for (int i = left; i <= right; i++)
            {
                res[k ++] = matrix[top][i];
            }
            top ++;

            for (int i = top; i <= bottom; i++)
            {
                res[k ++] = matrix[i][right];
            }
            right --;
            for (int i = right; i >= left && top <= bottom; i--)
            {
                res[k ++] = matrix[bottom][i];
            }
            bottom --;
            for (int i = bottom; i >= top && left <= right; i--)
            {
                res[k ++] = matrix[i][left];
            }
            left ++;
        }

        return res;
    }

    public static void main(String[] args)
    {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ints = spiralOrder(mat);
        for (int i = 0; i < ints.length; i++)
        {
            System.out.print(ints[i] + ",");
        }

    }


}
