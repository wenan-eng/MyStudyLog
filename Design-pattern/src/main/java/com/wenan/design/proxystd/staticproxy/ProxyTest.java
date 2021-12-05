package com.wenan.design.proxystd.staticproxy;

/**
 * 描述：    ProxyTest
 */
public class ProxyTest {
    public static void main(String[] args) {
        ProxyPhone proxyPhone = new ProxyPhone(new Apple());
        proxyPhone.buyPhone();

    }
}
