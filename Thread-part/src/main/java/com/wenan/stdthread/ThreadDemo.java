package com.wenan.stdthread;

/**
 * 描述：    ThreadDemo
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 通过继承Thread类实现自定义线程
        Mythread thread1 = new Mythread("thread1");
        Mythread thread2 = new Mythread("thread2");
        thread1.start();
        thread2.start();

        // 通过实现Runnable方法实现多线程
        MyRunnable thread3 = new MyRunnable("thread3");
        MyRunnable thread4 = new MyRunnable("thread4");
        new Thread(thread3).start();
        new Thread(thread4).start();
    }
}
