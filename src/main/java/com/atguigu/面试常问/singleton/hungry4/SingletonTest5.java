package com.atguigu.面试常问.singleton.hungry4;

public class SingletonTest5 {
    public static void main(String[] args) {

    }
}


//双重检查(懒汉式，线程安全)
class Singleton{
    private Singleton(){

    }

    private static volatile Singleton singleton;


    //提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
    //同时保证了效率, 推荐使用
    public static synchronized Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){//1、只有一个线程进入
                if (singleton == null){//2、后面进入的不会创建新的对象
                    singleton = new Singleton();
                }
            }
        }//3、再之后的不会进入 synchronized代码块，直接返回
        //线程安全，效率高
        return singleton;
    }
}
