package com.atguigu.math;

public class 丑数1
{

    public boolean isUgly(int num) {
        if (num < 1){
            return false;
        }

        if (num == 1){
            return true;
        }

        boolean isUgly = true;
        while (num > 1){
            if (num % 2 == 0){
                num /= 2;

            }else if (num % 3 == 0){
                num /= 3;
            }else if (num % 5 == 0){
                num /= 5;
            }else {
                isUgly = false;
                break;
            }
        }

        return isUgly;
    }
}
