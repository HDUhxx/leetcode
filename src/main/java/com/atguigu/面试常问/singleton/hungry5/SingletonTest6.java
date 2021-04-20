package com.atguigu.面试常问.singleton.hungry5;

public class SingletonTest6 {


}

class singleton{
    private singleton(){}

    private static class SingletonInstance{
        private static final singleton SINGLETON = new singleton();
    }

    public static synchronized singleton getInstance(){
        return SingletonInstance.SINGLETON;
    }
}
