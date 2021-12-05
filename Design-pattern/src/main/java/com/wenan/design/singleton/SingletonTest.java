package com.wenan.design.singleton;

/**
 * 描述：    SingletonTest
 */
public class SingletonTest {
    public static void main(String[] args) {
        /*
        尝试去
        new Singleton();
        提示对象构造方法未私有，不可以直接实例化
         */

        /*
        // 饿汉模式下的实例调用测试
        Singleton singleton = Singleton.getInstance();
        singleton.getMethod();
        System.out.println("singleton类id：" + singleton);
        */

        // 创建线程1
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Singleton instance = Singleton.getInstance();
                System.out.println("线程1：第" + i + "次调用" + instance);
            }
        });

        // 创建线程2
        Thread thread2= new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Singleton instance = Singleton.getInstance();
                System.out.println("线程2：第" + i + "次调用" + instance);
            }
        });

        thread1.start();
        thread2.start();

    }
}
