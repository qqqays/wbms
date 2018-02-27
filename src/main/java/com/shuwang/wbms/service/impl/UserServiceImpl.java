package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.UserEntity;
import com.shuwang.wbms.entity.UserRoleEntity;
import com.shuwang.wbms.mapper.UserMapper;
import com.shuwang.wbms.service.IUserRoleService;
import com.shuwang.wbms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public boolean deleteById(Serializable id) {

        UserEntity userEntity = super.selectById(id);

        return userRoleService.delete(new EntityWrapper<UserRoleEntity>().eq("userName", userEntity.getUserName()))
                && super.deleteById(id);
    }
}
