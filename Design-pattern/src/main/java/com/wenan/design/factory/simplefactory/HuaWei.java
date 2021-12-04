package com.wenan.design.factory.simplefactory;

/**
 * 描述：    HuaWei
 */
public class HuaWei implements Product {
    @Override
    public void create() {
        System.out.println("Create HuaWei!");
    }
}
