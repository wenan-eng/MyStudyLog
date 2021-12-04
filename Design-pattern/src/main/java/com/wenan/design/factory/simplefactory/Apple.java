package com.wenan.design.factory.simplefactory;

/**
 * 描述：    Apple
 */
public class Apple implements Product {
    @Override
    public void create() {
        System.out.println("Create Apple!");
    }
}
