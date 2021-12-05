package com.wenan.design.factory.reflectfactory;

import com.wenan.design.factory.simplefactory.Product;

/**
 * 描述：    ReflectFactoryImpl
 */
public class ReflectFactoryImpl implements ReflectFactory {

    private Object object;

    ReflectFactoryImpl(String string) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> obj = Class.forName(string);
         this.object=obj.newInstance();
    }

    @Override
    public Object createObject(String string) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> obj = Class.forName(string);
        return obj.newInstance();
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
