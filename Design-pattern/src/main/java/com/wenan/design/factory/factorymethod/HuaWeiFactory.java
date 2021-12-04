package com.wenan.design.factory.factorymethod;

import com.wenan.design.factory.simplefactory.HuaWei;
import com.wenan.design.factory.simplefactory.Product;

/**
 * 描述：    HuaWeiFactory
 */
public class HuaWeiFactory implements IFactory {

    @Override
    public Product creatProduct() {
        return new HuaWei();
    }
}
