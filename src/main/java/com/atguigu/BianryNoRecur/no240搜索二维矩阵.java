package com.atguigu.BianryNoRecur;

public class no240搜索二维矩阵
{
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int m = 0,n = matrix[0].length;
        while (m < matrix.length && n > 0){
            if (matrix[m][n] > target){
                n --;
            }else if (matrix[m][n] < target){
                m ++;
            }else {
                return true;
            }
        }
        return false;
    }
}
