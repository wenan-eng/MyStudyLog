package com.wenan.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：    CompositeDemo
 */
public class CompositeDemo {
    public static void main(String[] args) {
        // 新建树对象
        Branch tree = new Branch("树");
        // 新建树枝对象
        Branch branch1 = new Branch("树枝1");
        Branch branch2 = new Branch("树枝2");
        // 新建5个树叶对象
        Leaf leaf1 = new Leaf("树叶1");
        Leaf leaf2 = new Leaf("树叶2");
        Leaf leaf3 = new Leaf("树叶3");
        Leaf leaf4 = new Leaf("树叶4");
        Leaf leaf5 = new Leaf("树叶5");
        // 把对象都添加到树中
        tree.add(leaf1);
        tree.add(branch1);
        branch1.add(leaf2);
        branch1.add(leaf3);
        branch1.add(branch2);
        branch2.add(leaf4);
        branch2.add(leaf5);
        // 展示所有树叶

        tree.show();
    }
}


/*// 创建抽象类(透明方式)
interface Composite{
    // 增加子节点方法
    void add(Composite composite);

    // 删除子节点方法
    void remove(Composite composite);

    // 获取子节点方法
    Composite getChild(int i);

    // 展示子节点方法
    void show();
}*/

// 创建抽象类(隐藏方式)
interface Composite{
    // 展示子节点方法,所有的子类都有的共同方法
    void show();
}

// 树叶类对象
class Leaf implements Composite {
    // 树叶名称
    private String leadName;

    Leaf(String name){
        this.leadName = name;
    }

    public void add(Composite composite) {
        //树枝无此方法，所以不实现
    }

    public void remove(Composite composite) {
        //树枝无此方法，所以不实现
    }

    public Composite getChild(int i) {
        //树枝无此方法，所以不实现
        return null;
    }

    @Override
    public void show() {
        System.out.println(leadName);
    }
}

// 树枝类对象
class Branch implements Composite {
    // 树枝名称
    private String branchName;

    // 树枝下面的树叶
    private List<Composite> children = new ArrayList<>();

    Branch(String name) {
        this.branchName = name;
    }

    /**
     * 增加树叶
     */
    public void add(Composite composite) {
        children.add(composite);
    }

    /**
     * 删除树叶
     */
    public void remove(Composite composite) {
        children.remove(composite);
    }

    /**
     * 获取下一级节点
     */
    public Composite getChild(int i) {
        return children.get(i);
    }

    /**
     * 展示所有节点
     */
    @Override
    public void show() {
        System.out.println("这是："+branchName+"包含下面节点");
        for (Composite composite : children) {
            composite.show();
        }
    }
}