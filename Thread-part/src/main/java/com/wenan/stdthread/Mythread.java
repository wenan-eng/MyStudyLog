package com.wenan.stdthread;

/**
 * 描述：   继承Thread类，实现一个自定义线程
 */
public class Mythread extends Thread{
    // 线程共享的对象
    private Integer money = 100;

    private String name;

    Mythread(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            if (money > 0) {
                money = money - 10;
                System.out.println(name+"取出了10元，还剩"+money+"元");
            }
        }
    }
}
