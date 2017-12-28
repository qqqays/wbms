package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.UserEntity;
import com.shuwang.wbms.mapper.UserMapper;
import com.shuwang.wbms.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService{
}
