package com.wenan.design.factory.abstractfactory;

import com.wenan.design.factory.simplefactory.Apple;
import com.wenan.design.factory.simplefactory.Product;

/**
 * 描述：    AbstractFactoryTest
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory superFactory = new SuperFactory();
        Product apple = superFactory.createApple();
        Product huawei = superFactory.createHuawei();
        apple.create();
        huawei.create();

    }
}
