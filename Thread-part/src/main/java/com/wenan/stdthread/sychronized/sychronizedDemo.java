package com.wenan.stdthread.sychronized;

/**
 * 描述：    sychronizedDemo
 */
public class sychronizedDemo {
    public static void main(String[] args) {
        MyThread wangxiaoer = new MyThread("王小二");
        new Thread(wangxiaoer).start();
        new Thread(wangxiaoer).start();
        new Thread(wangxiaoer).start();
    }
}
