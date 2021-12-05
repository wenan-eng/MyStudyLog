package com.wenan.design.proxystd.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * 描述：    CglibTest
 */
public class CglibTest {

    public static void main(String[] args) {
        // 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 设置目标类的字节码文件
        enhancer.setSuperclass(Huawei.class);
        // 设置回调函数
        enhancer.setCallback(new MethodHandler());

        // 正式创建代理
        Huawei huawei = (Huawei) enhancer.create();

        huawei.makeHuawei();
    }
}
