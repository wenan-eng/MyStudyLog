package com.wenan.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：    AdminController
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/hello")
    public String hello() {
        return "admin-hello";
    }

    @GetMapping("/stop")
    public String stop() {
        return "admin-stop";
    }
}
