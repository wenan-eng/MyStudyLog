package com.wenan.design.factory.reflectfactory;

/**
 * 描述：    BeanFactory
 */
public class BeanFactory {
    private Object object;

    /**
     * 构造方法，根据传入的类路径获取类的实例
     * @param s 类的路径
     * @throws ClassNotFoundException 类找不到异常
     * @throws IllegalAccessException 不可达异常
     * @throws InstantiationException 实例化失败异常
     */
    BeanFactory(String s) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(s);
        this.object = aClass.newInstance();
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
