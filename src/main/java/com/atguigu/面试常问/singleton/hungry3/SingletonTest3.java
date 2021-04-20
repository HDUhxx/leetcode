package com.atguigu.面试常问.singleton.hungry3;

public class SingletonTest3 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance" + instance.hashCode());
        System.out.println("instance" + instance.hashCode());
    }
}

class Singleton{
    private Singleton(){};

    private static Singleton instance;


    //同步方法解决线程安全（懒汉式）
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
