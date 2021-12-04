package com.wenan.test.subject;

/**
 * 描述：    Student
 */
public class Student {

    private String name;

    private String sex;



    public  Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public static void main(String[] args) {
        Student student = new Student("zhangsan", "man");
        System.out.println(student);
    }


}
