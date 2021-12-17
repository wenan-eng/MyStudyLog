package com.wenan.shirotest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wenan.shirotest.entity.User;
import com.wenan.shirotest.mapper.UserMapper;
import com.wenan.shirotest.service.UserService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 描述：    UserMappterTest
 */
@SpringBootTest
public class UserMappterTest {
    @Resource
    UserMapper userMapper;

    @Resource
    UserService userService;

    @Test
    public void testMapper() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", "zhangsan");
        User user = userMapper.selectOne(userQueryWrapper);
        System.out.println(user);
    }
}
