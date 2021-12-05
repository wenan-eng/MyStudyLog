package com.wenan.design.proxystd.staticproxy;

/**
 * 描述：    ProxyPhone
 */
public class ProxyPhone implements Phone {


    private Phone phone;

    ProxyPhone() {
        this.phone = new ProxyPhone();
    }

    ProxyPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void buyPhone() {
        System.out.println("执行之前做的事情");
        this.phone.buyPhone();
        System.out.println("执行之后做的事情");
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
