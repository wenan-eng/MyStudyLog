package com.wenan.design.factory.simplefactory;

/**
 * 描述：
 */
public class Apple implements Product {
    @Override
    public void create() {
        System.out.println("Create Apple!");
    }
}
