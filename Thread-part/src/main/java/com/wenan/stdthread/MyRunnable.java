package com.wenan.stdthread;

/**
 * 描述：    MyRunnable
 */
public class MyRunnable implements Runnable {
    private String name;

    MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + "正在运行" + i);
            try {
                // 随机暂停时间，以查看差异
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
