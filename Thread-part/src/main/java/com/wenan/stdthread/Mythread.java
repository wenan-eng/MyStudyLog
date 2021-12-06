package com.wenan.stdthread;

/**
 * 描述：   继承Thread类，实现一个自定义线程
 */
public class Mythread extends Thread{

    private String name;

    Mythread(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(name+"正在运行"+i);
            try {
                // 随机暂停时间，以查看差异
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
