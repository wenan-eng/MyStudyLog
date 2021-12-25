package com.wenan.eldemo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 描述：    User
 */
@Data
public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
