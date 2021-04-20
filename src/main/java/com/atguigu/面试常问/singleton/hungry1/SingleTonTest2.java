package com.atguigu.面试常问.singleton.hungry1;

public class SingleTonTest2 {


}

class Singleton {
    private Singleton(){

    }

    private static Singleton singleTon;

    static {//在静态代码块中，创建单例对象
        singleTon = new Singleton();
    }

    public Singleton getInstance(){
        return singleTon;
    }
}
