package com.atguigu.面试常问;

import org.junit.Test;

import java.util.Scanner;

public class Tests {

    public static void main(String[] args) {
        double[][] doubles = excuteMethod();
        for (int i = 0; i < doubles.length; i++) {
            for (int j = 0; j < doubles[0].length; j++) {
                System.out.print(doubles[i][j]);
            }
        }
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
    }


    public static double[][] excuteMethod() {
        double R = 100;
        double T = 0.1;
        double k1 = 5;
        double a1 = 2;

        double yu = 1;
        double kp = 1;
        double ki = 0.1;
        double kd = 1;
        int rangeT = 2000;
        double[][] result = new double[2][rangeT];//返回的结果
        double[] y0 = new double[rangeT];
        double[] y1 = new double[rangeT];

        double[] e1 = new double[rangeT];
        double[] e2 = new double[rangeT];
        double[] u1 = new double[rangeT];
        double[] u2 = new double[rangeT];
        e1[0] = R;
        e2[0] = R;
        if(Math.abs(e1[0])<=yu){
            u1[0] = kp * (e1[0]) + ki * e1[0] + kd * (e1[0]);
        }else {
            u1[0] = kp * (e1[0]) + kd * (e1[0]);
        }
        u2[0] = kp * (e2[0]) + ki * e2[0] + kd * (e2[0]);
        y0[0] = (k1 * T * T * u1[0]) / (1 + a1 * T);
        y1[0] = (k1 * T * T * u2[0]) / (1 + a1 * T);

        e1[1] = R - y0[0];
        e2[1] = R - y1[0];
        if(Math.abs(e1[1])<=yu){
            u1[1] = u1[0] + kp * (e1[1] - e1[0]) + ki * e1[1] + kd * (e1[1] - 2 * e1[0]);
        }else {
            u1[1] = u1[0] + kp * (e1[1] - e1[0]) + kd * (e1[1] - 2 * e1[0]);
        }
        u2[1] = u2[0] + kp * (e2[1] - e2[0]) + ki * e2[1] + kd * (e2[1] - 2 * e2[0]);
        y0[1] = ((2 + a1 * T) * y0[0] + k1 * T * T * (u1[1] - u1[0])) / (1 + a1 * T);
        y1[1] = ((2 + a1 * T) * y1[0] + k1 * T * T * (u2[1] - u2[0])) / (1 + a1 * T);

        for (int k = 2; k < rangeT; k++)
        {
            e1[k] = R - y0[k - 1];
            e2[k] = R - y1[k - 1];
            if(Math.abs(e1[k])<=yu){
                u1[k] = u1[k - 1] + kp * (e1[k] - e1[k - 1]) + ki * e1[k] + kd * (e1[k] - 2 * e1[k - 1] + e1[k - 2]);
            }else {
                u1[k] = u1[k - 1] + kp * (e1[k] - e1[k - 1]) + kd * (e1[k] - 2 * e1[k - 1] + e1[k - 2]);
            }
            u2[k] = u2[k - 1] + kp * (e2[k] - e2[k - 1]) + ki * e2[k] + kd * (e2[k] - 2 * e2[k - 1] + e2[k - 2]);
            y0[k] = ((2 + a1 * T) * y0[k - 1] - y0[k - 2] + k1 * T * T * (u1[k] - u1[k - 1])) / (1 + a1 * T);
            y1[k] = ((2 + a1 * T) * y1[k - 1] - y1[k - 2] + k1 * T * T * (u2[k] - u2[k - 1])) / (1 + a1 * T);
        }

        result[0] = y0;
        result[1] = y1;
        return result;
    }



}
