package com.wenan.security.service.impl;

import com.wenan.security.entity.User;
import com.wenan.security.mapper.UserMapper;
import com.wenan.security.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenan
 * @since 2021-12-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
