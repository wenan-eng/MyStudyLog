package com.wenan.design.factory.reflectfactory;

import com.wenan.design.factory.simplefactory.Product;

/**
 * 描述：    ReflectTest
 */
public class ReflectTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String appleClassPath="com.wenan.design.factory.simplefactory.Apple";
        String huaweiClassPath="com.wenan.design.factory.simplefactory.HuaWei";

        BeanFactory appleFactory = new BeanFactory(appleClassPath);
        Product apple = (Product) appleFactory.getObject();
        apple.create();

        BeanFactory huaweiFactory = new BeanFactory(huaweiClassPath);
        Product huawei  = (Product)huaweiFactory.getObject();
        huawei.create();
    }
}
