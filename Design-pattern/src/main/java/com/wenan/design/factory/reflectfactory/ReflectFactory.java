package com.wenan.design.factory.reflectfactory;

/**
 * 描述：    ReflectFactory
 */
public interface ReflectFactory {

    Object createObject(String string) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}
