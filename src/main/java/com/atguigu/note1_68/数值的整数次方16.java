package com.atguigu.note1_68;

public class 数值的整数次方16 {




    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        if (n >= 0){
            return power(x,n);
        }else {
            return power(1/x,-n);
        }

    }

    private double power(double x, int n) {

        if (n == 0){
            return 1;
        }

        double res = power(x,n / 2);

        if ((n & 1) == 1){
            return res * res * x;
        }else {
            return res * res;
        }

    }
}
