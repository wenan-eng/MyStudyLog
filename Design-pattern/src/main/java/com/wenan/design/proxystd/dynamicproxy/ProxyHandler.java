package com.wenan.design.proxystd.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述：    ProxyHandler 用于实现动态代理
 */
public class ProxyHandler implements InvocationHandler {
    // 目标对象
    private Object object;

    /**
     * 该方法用于未指定类状态奇、一组接口及调用处理器生成动态代理类实例。
     */
    public Object newInstance(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this);
    }

    /**
     * 关联这个实现类的方法被调用时将被执行
     * @param proxy 代理类
     * @param method 原对象被调用的方法
     * @param args 方法村塾
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理--对象方法调用前的逻辑");
        // 调用目标方法
        Object invoke = method.invoke(this.object, args);
        System.out.println("动态代理--对象方法调用后的逻辑");
        return invoke;
    }
}
