package com.wenan.design.factory.factorymethod;

import com.wenan.design.factory.simplefactory.Product;

/**
 * 描述：    Test
 */
public class Test {

    public static void main(String[] args) {
        // 想要Apple产品，则使用Apple工厂
        IFactory appleFactory = new AppleFactory();
        Product apple = appleFactory.creatProduct();
        apple.create();

        // 想要HuaWei产品，则使用HuaWei工厂
        IFactory huaweiFactory = new HuaWeiFactory();
        Product huawei = huaweiFactory.creatProduct();
        huawei.create();

    }
}
