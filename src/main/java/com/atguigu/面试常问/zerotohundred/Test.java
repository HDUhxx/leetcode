package com.atguigu.面试常问.zerotohundred;

public class Test {
    volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (i <= 100){
                if (i % 2 == 0){
                    System.out.println("偶数" + i);
                    i ++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (i <= 100){
                if (i % 2 == 1){
                    System.out.println("奇数" + i);
                    i ++;
                }
            }
        });
        t1.start();
        Thread.sleep(1);
        t2.start();
    }
}
