package com.atguigu.面试常问.singleton.test;


public class SingletonTest8 {

    public static void main(String[] args) {
        /*Singleton singleton = Singleton.SINGLETON;
        Singleton singleton1 = Singleton.SINGLETON;
        System.out.println(singleton == singleton1);*/
    }
}

class Singleton{

    /*懒汉式，提供一个方法，当被调用时才会创建实例，但是存在线程安全问题
    private Singleton(){}

    private static Singleton singleton;

    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }*/

    /*加锁 同步方法实现线程安全
    private Singleton(){}

    private static Singleton singleton;

    public static synchronized Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }*/

    /*双重检查
    private Singleton(){};

    private static volatile Singleton singleton;

    public static synchronized Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/

    /*静态常量（饿汉式）
    private Singleton(){}

    private static final Singleton SINGLETON = new Singleton();

    public static final Singleton getInstance(){
        return SINGLETON;
    }*/


}
