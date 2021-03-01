package com.atguigu.note1_68;

public class 二维数组中的查找4
{
    public boolean findNumberIn2DArray1(int[][] matrix, int target)
    {
        if (matrix.length == 0)
        {
            return false;
        }
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == target)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return false;
        }
        int m = 0, n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0)
        {
            if (matrix[m][n] == target)
            {
                return true;
            }
            else if (matrix[m][n] > target)
            {
                n--;
            }
            else if (matrix[m][n] < target)
            {
                m++;
            }
        }
        return false;
    }
}
