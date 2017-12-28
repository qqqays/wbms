package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.UserRoleEntity;
import com.shuwang.wbms.mapper.UserRoleMapper;
import com.shuwang.wbms.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:31
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements IUserRoleService{
}
