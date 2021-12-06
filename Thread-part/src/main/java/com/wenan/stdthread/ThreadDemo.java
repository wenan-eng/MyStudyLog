package com.wenan.stdthread;

/**
 * 描述：    ThreadDemo
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Mythread thread1 = new Mythread("thread1");
        Mythread thread2 = new Mythread("thread2");
        thread1.start();
        thread2.start();
    }
}
