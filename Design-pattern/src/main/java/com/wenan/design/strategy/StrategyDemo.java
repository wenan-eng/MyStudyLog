package com.wenan.design.strategy;

/**
 * 描述：    StrategyDemo
 */
public class StrategyDemo {
    public static void main(String[] args) {
        int way = 500;
        if (way > 1000) {
            System.out.println("坐飞机");
        } else if (1000 > way && way > 500) {
            System.out.println("坐火车");
        }else {
            System.out.println("坐汽车");
        }

        System.out.println("---------下面是策略模式实现--------");
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
 * 策略工厂
 */
class StrategyFactory {
    private static StrategyFactory factory = new StrategyFactory();

    public static StrategyFactory getInstance(){
        return factory;
    }

    public Strategy getStrategyType(Integer way) {
        if (way > 1000) {
            return new Plane();
        } else if (1000 > way && way > 500) {
            return new Train();
        }else {
            return new Car();
        }
    }
}

/**
 * 具体环境
 */
class context {
    private Strategy strategy;

    public  context(Integer way) {
        this.strategy = StrategyFactory.getInstance().getStrategyType(way);
    }


    public void getStrategyMethod() {
        strategy.doStrategyMethod();
    }
}
