package com.wenan.shirotest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wenan.shirotest.entity.User;
import com.wenan.shirotest.mapper.UserMapper;
import com.wenan.shirotest.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.authc.Account;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenan
 * @since 2021-12-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void testMapper() {
        User user = baseMapper.selectById(2);
        System.out.println(user);

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", "zhangsan");
        User user1 = baseMapper.selectOne(userQueryWrapper);
        System.out.println(user1);
    }

    @Override
    public User findByUsername(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        return baseMapper.selectOne(wrapper);
    }

}
