package com.atguigu.面试常问.zerotohundred;

public class Test1 {
    static volatile int i = 0;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
           while (i <= 100){
               synchronized (lock){
                   lock.notify();
                   System.out.println(i + "偶数");
                   i ++;
                   try {
                       if (i <= 100){
                           lock.wait();
                       }
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        });

        Thread t2 = new Thread(() -> {
            while (i <= 100){
                synchronized (lock){
                    lock.notify();
                    System.out.println(i + "奇数");
                    i ++;
                    try {
                        if (i <= 100){
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        Thread.sleep(1);
        t2.start();
    }
}
