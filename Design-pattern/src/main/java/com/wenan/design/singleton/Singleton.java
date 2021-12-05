package com.wenan.design.singleton;

/**
 * 描述：    Singleton
 */
public class Singleton {

    private static class SingletonHolder{
        private static final Singleton singleton = new Singleton();
    }

    // 定义Singleton变量为私有，无法从外界访问
    private Singleton() {
    }

    // 暴露创建Singleton的方法，让外界可以访问
    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    public void getMethod() {
        System.out.println("singleton方法");
    }
}
