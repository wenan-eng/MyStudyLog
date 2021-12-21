package com.wenan.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * 描述：    SecurityDemo
 */
@SpringBootApplication
@EnableWebSecurity
@MapperScan(basePackages = "com.wenan.security.mapper")
public class SecurityDemo {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemo.class, args);
    }
}
