package com.wenan.shirotest.service;

import com.wenan.shirotest.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.shiro.authc.Account;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenan
 * @since 2021-12-16
 */
public interface UserService extends IService<User> {

    void testMapper();

    User findByUsername(String username);
}
