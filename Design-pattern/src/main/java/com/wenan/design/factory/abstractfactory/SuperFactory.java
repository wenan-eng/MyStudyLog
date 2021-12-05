package com.wenan.design.factory.abstractfactory;

import com.wenan.design.factory.simplefactory.Apple;
import com.wenan.design.factory.simplefactory.HuaWei;

/**
 * 描述：    SuperFactory
 */
public class SuperFactory implements AbstractFactory {
    @Override
    public Apple createApple() {
        return new Apple();
    }

    @Override
    public HuaWei createHuawei() {
        return new HuaWei();
    }
}
