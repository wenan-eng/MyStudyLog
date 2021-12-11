package com.wenan.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：    IteratorDemo
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Concurrent concurrent = new Concurrent();
        concurrent.add("1");
        concurrent.add("2");
        concurrent.add("3");
        concurrent.add("4");
        Iterator iterator = concurrent.getIterator();
        boolean hasNext = iterator.hasNext();
        System.out.println("是否有下一个：" + hasNext);
        String first = (String)iterator.first();
        System.out.println("First:"+first);
        Object next = iterator.next();
        System.out.println("next:" + next);
        Object last = iterator.last();
        System.out.println("last:" + last);
    }
}

/**
 * 聚合抽象类
 */
interface Aggregate{
    void add(Object object);

    void remove(Object object);

    Iterator getIterator();
}

/**
 * 聚合实体类
 */
class Concurrent implements Aggregate {
    List<Object> list = new ArrayList<>();

    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public void remove(Object object) {
        list.remove(object);
    }

    @Override
    public Iterator getIterator() {
        return (new ConcurrentIterator(list));
    }
}


/**
 * 迭代器抽象类
 */
interface Iterator{
    boolean hasNext();

    Object first();

    Object next();

    Object last();
}

/**
 * 具体迭代器类
 */
class ConcurrentIterator implements Iterator {
    private List<Object> list = null;
    private int index= -1;

    ConcurrentIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object first() {
        index = 0;
        if (this.hasNext()) {
            return list.get(index);
        }
        return null;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public Object last() {
        index = list.size() - 1;
        if (this.hasNext()) {
            return list.get(index);
        }
        return null;
    }
}
