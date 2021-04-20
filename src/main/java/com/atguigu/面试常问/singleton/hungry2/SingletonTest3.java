package com.atguigu.面试常问.singleton.hungry2;

public class SingletonTest3 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }

}

class Singleton{
    private Singleton(){};

    private static Singleton singleton;

    //提供一个静态的公有方法，当使用到该方法时，才去创建 instance,有线程安全问题（考虑双重检查）
    //即懒汉式
    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
