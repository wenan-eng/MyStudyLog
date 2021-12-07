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
        // 创建罗某账户多项
        RealSubject MrLuo = new RealSubject();

        // 创建银行对象
        RealObserver bankA = new RealObserver("bankA");
        RealObserver bankB = new RealObserver("bankB");
        RealObserver bankc = new RealObserver("bankc");

        // 添加欠款银行(订阅）
        MrLuo.add(bankA);
        MrLuo.add(bankB);
        MrLuo.add(bankc);

        // 罗某账户工资到账，对欠款的都发出提醒
        MrLuo.notifyObserver();

        System.out.println("----银行C的钱还完了---");

        // 移除观察者（取消订阅）
        MrLuo.remove(bankc);

        // 罗某账户工资到账，对欠款的都发出提醒
        MrLuo.notifyObserver();
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
        System.out.println(name + "知道了罗某账户有资金到账");
    }
}



