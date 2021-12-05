package com.wenan.design.proxystd.staticproxy;

/**
 * 描述：    Apple
 */
public class Apple implements Phone{

    @Override
    public void buyPhone() {
        System.out.println("买苹果手机");
    }

}
