package com.wenan.stdthread.sychronized;

import com.wenan.stdthread.Mythread;

/**
 * 描述：    MyThread
 */
public class MyThread implements Runnable {
    // 线程共享的对象
    private Integer money = 100;

    // 对象名称
    private String name;

    MyThread(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        MyThread wangxiaoer = new MyThread("王小二");
        new Thread(wangxiaoer).start();
        new Thread(wangxiaoer).start();
        new Thread(wangxiaoer).start();
    }

    @Override
    // synchronized分别可以加在这些地方
    public /*synchronized*/ void run() {

        for (int i = 0; i < 50; i++) {
            synchronized (this) {
                if (money > 0) {
                    int take = 10;
                    money = money - take;
                    System.out.println(Thread.currentThread().getName()+"第"+i+"次执行：" + name + "取出了" + take + "元，还剩" + money + "元");
                }else  {
                    int take = 5;
                    money = money + take;
                    System.out.println(Thread.currentThread().getName()+"第"+i+"次执行：" +name + "存入了" + take + "元，还剩" + money + "元");
                }
            }
        }
    }
}
