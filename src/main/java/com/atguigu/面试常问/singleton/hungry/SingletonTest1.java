package com.atguigu.面试常问.singleton.hungry;

public class SingletonTest1 {
    public static void main(String[] args) {

    }
}

//饿汉式的单例模式
class Singleton {
    //1. 构造器私有化, 外部能new
    private Singleton() {

    }

    //2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }


}
