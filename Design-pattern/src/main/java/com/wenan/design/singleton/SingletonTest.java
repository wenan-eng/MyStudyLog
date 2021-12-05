package com.wenan.design.singleton;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

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
            long startTime = new Date().getTime();
            System.out.println(startTime);
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程1：第" + i + "次调用" + EnumSingleton.INSTANCE);
            }
            long endTime = new Date().getTime();
            System.out.println(endTime);
            String times = (Long.valueOf(endTime-startTime)).toString();
            System.out.println("-------------------耗时-"+times+"----------------------------------");
        });

        // 创建线程2
        Thread thread2= new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Singleton instance = Singleton.getInstance();
                System.out.println("线程2：第" + i + "次调用" + EnumSingleton.INSTANCE);
            }
        });


        thread1.start();
        thread2.start();



    }
}
