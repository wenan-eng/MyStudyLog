package com.wenan.design.proxystd.dynamicproxy;

import com.wenan.design.proxystd.staticproxy.Apple;
import com.wenan.design.proxystd.staticproxy.Phone;

/**
 * 描述：    dynamicTest
 */
public class dynamicTest {
    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        Phone apple = (Phone) proxyHandler.newInstance(new Apple());
        apple.buyPhone();
    }
}
