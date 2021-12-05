package com.wenan.design.singleton;

/**
 * 描述：    Singleton
 */
public class Singleton {

    private static  Singleton singleton;

    // 定义Singleton变量为私有，无法从外界访问
    private Singleton() {
    }

    // 暴露创建Singleton的方法，让外界可以访问
    public static synchronized Singleton getInstance() {
        // 当实例没有的时候，就创建实例，并把实例赋值给singleton
        if (singleton == null) {
            singleton = new Singleton();
        }
        // 当已经有实例的时候，直接返回实例
        return singleton;
    }

    public void getMethod() {
        System.out.println("singleton方法");
    }
}
