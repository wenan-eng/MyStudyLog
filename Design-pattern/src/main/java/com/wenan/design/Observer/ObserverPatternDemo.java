package com.wenan.design.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象被观察者接口
 */
interface Subject {
    // 增加观察者
    void add(Observer observer);

    // 删除观察者
    void remove(Observer observer);

    // 通知观察者
    void notifyObserver();
}

/**
 * 抽象观察者接口
 */
interface Observer {
    void getMessage();
}

/**
 * 描述：    ObserverPatternDemo
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        // 创建被观察者对象
        RealSubject realSubject = new RealSubject();

        // 创建观察者对象
        RealObserver lucy = new RealObserver("Lucy");
        RealObserver jhon = new RealObserver("Jhon");
        RealObserver Konna = new RealObserver("Konna");

        // 添加观察者(订阅）
        realSubject.add(lucy);
        realSubject.add(jhon);
        realSubject.add(Konna);
        // 更新消息
        realSubject.notifyObserver();

        System.out.println("----移除Konna---");

        // 移除观察者（取消订阅）
        realSubject.remove(Konna);
        realSubject.notifyObserver();
    }


}

/**
 * 具体被观察者对象
 */
class RealSubject implements Subject {
    // 观察者集合
    List<Observer> observerList = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.getMessage();
        }
    }
}

/**
 * 具体观察者
 */
class RealObserver implements Observer {
    private String name;

    RealObserver(String name) {
        this.name = name;
    }

    @Override
    public void getMessage() {
        System.out.println(name + "收到了消息");
    }
}



