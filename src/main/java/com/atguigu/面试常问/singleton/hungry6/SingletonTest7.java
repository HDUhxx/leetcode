package com.atguigu.面试常问.singleton.hungry6;

public class SingletonTest7 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.SINGLETON;
        Singleton singleton1 = Singleton.SINGLETON;
        System.out.println(singleton == singleton1);
    }
}

enum  Singleton{
    SINGLETON;
    public void save(){
        System.out.println("ok");
    }
}
