package com.wenan.stdthread.sychronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：    Mythread2
 */
public class Mythread2 implements Runnable {
    Lock lock = new ReentrantLock();
    // 线程共享的对象
    private Integer money = 100;
    // 对象名称
    private String name;

    Mythread2(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Mythread2 wangxiaoer = new Mythread2("王小二");
        new Thread(wangxiaoer).start();
        new Thread(wangxiaoer).start();
        new Thread(wangxiaoer).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            lock.lock();
            try {
                if (money > 0) {
                    int take = 10;
                    money = money - take;
                    System.out.println(Thread.currentThread().getName()+"第"+i+"次执行：" + name + "取出了" + take + "元，还剩" + money + "元");
                }else  {
                    int take = 5;
                    money = money + take;
                    System.out.println(Thread.currentThread().getName()+"第"+i+"次执行：" +name + "存入了" + take + "元，还剩" + money + "元");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}
