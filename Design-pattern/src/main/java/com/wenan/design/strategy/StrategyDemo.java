package com.wenan.design.strategy;

/**
 * 描述：    StrategyDemo
 */
public class StrategyDemo {
    public static void main(String[] args) {
        int way = 500;

        System.out.println("---------用if else语句判断--------");
        if (way > 1000) {
            System.out.println("坐飞机");
        } else if (1000 > way && way > 500) {
            System.out.println("坐火车");
        }else {
            System.out.println("坐汽车");
        }

        System.out.println("---------策略模式实现--------");
        context context = new context(way);
        context.getStrategyMethod();
    }
}

/**
 * 抽象策略接口
 */
interface Strategy {

    void doStrategyMethod();
}

/**
 * 具体策略1
 */
class Plane implements Strategy {

    @Override
    public void doStrategyMethod() {
            System.out.println("坐飞机");
    }
}

/**
 * 具体策略2
 */
class Train implements Strategy {

    @Override
    public void doStrategyMethod() {
            System.out.println("坐火车");
    }
}

/**
 * 具体策略3
 */
class Car implements Strategy {

    @Override
    public void doStrategyMethod() {
            System.out.println("坐汽车");
    }
}


/**
 * 具体环境
 */
class context {
    private Strategy strategy;

    public  context(Integer way) {
        if (way > 1000) {
            this.strategy = new Plane();
        } else if (1000 > way && way > 500) {
            this.strategy = new Train();
        }else {
            this.strategy = new Car();
        }
    }


    public void getStrategyMethod() {
        strategy.doStrategyMethod();
    }
}
