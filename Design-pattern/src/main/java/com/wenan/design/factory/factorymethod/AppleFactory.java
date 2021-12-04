package com.wenan.design.factory.factorymethod;

import com.wenan.design.factory.simplefactory.Apple;
import com.wenan.design.factory.simplefactory.Product;

/**
 * 描述：    AppleFactory
 */
public class AppleFactory implements IFactory{
    @Override
    public Product creatProduct() {
        return new Apple();
    }
    
}
