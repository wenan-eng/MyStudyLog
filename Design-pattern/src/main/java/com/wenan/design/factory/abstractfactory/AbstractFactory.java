package com.wenan.design.factory.abstractfactory;

import com.wenan.design.factory.simplefactory.Apple;
import com.wenan.design.factory.simplefactory.HuaWei;

public interface AbstractFactory {

    Apple createApple();

    HuaWei createHuawei();
}
