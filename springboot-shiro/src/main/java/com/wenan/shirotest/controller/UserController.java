package com.wenan.shirotest.controller;




import com.wenan.shirotest.entity.User;
import com.wenan.shirotest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wenan
 * @since 2021-12-16
 */
@Api(value = "用户管理界面")
@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "测试获取所有用户")
    @GetMapping("getuser")
    public String getUser() {
        userService.testMapper();
        return "ok";
    }

    @ApiOperation(value = "返回对应页面")
    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    @ApiOperation(value = "登录页面")
    @PostMapping("/login")
    public String login(String username, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            subject.getSession().setAttribute("user",user);
            return "登录成功";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名错误");
            return "用户名错误";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "密码错误";
        }
    }

    @ApiOperation(value = "注销页面")
    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "注销成功，请重新登录";
    }

    @ApiOperation(value = "未授权页面")
    @RequestMapping("/unauth")
    public String unauth(){
        return "未授权没有访问权限";
    }
}

