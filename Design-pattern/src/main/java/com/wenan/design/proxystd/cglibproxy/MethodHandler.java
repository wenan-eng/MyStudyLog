package com.wenan.design.proxystd.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 描述：    MethodHandler
 */
public class MethodHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行之前做的事情--cglib代理");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("执行之后做的事情--cglib代理");
        return object;
    }
}
