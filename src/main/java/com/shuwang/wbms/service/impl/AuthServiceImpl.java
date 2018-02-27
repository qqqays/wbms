package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.AuthEntity;
import com.shuwang.wbms.entity.RoleAuthEntity;
import com.shuwang.wbms.mapper.AuthMapper;
import com.shuwang.wbms.service.IAuthService;
import com.shuwang.wbms.service.IRoleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:31
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, AuthEntity> implements IAuthService {

    @Autowired
    private IRoleAuthService roleAuthService;

    @Override
    public boolean deleteById(Serializable id) {

        AuthEntity authEntity = super.selectById(id);

        return roleAuthService.delete(new EntityWrapper<RoleAuthEntity>().eq("authName", authEntity.getAuthName()))
                && super.deleteById(id);
    }
}
