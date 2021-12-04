package com.wenan.testjvm;

/**
 * 描述：    Student
 */
public class Student {

    private String name=Constant.STD_NAME;

    private String sex = Constant.STD_SEX;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
