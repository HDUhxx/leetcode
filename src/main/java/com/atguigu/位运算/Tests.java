package com.atguigu.位运算;

public class Tests {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }

        int[] res = new int[matrix.length * matrix[0].length];
        int k = 0;
        int top = 0,left = 0;
        int bottom = matrix.length - 1,right = matrix[0].length - 1;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++) {
                res[k ++] = matrix[top][i];
            }
            top ++;
            for (int i = top; i <= bottom; i++) {
                res[k ++] = matrix[i][right];
            }
            right --;
            for (int i = right; i >= left && top <= bottom; i--) {
                res[k ++] = matrix[bottom][i];
            }
            bottom --;
            for (int i = bottom; i >= top && left <= right; i--) {
                res[k ++] = matrix[i][left];
            }
            left ++;
        }
        return res;
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n >= 0){
            return pow(x,n);
        }else {
            return pow(1/x,-n);
        }
    }

    private double pow(double x,int n){
        if (n == 0){
            return 1;
        }
        double res = pow(x,n/2);
        if (n % 2 == 0){//判断n是否为偶数
            return res * res;
        }else {
            return res * res * x;
        }

    }

    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) == '1' ? '0' : '1');
        }
        return Integer.valueOf(sb.toString());

    }
}
