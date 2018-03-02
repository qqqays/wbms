package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.RoleAuthEntity;
import com.shuwang.wbms.entity.RoleEntity;
import com.shuwang.wbms.entity.UserRoleEntity;
import com.shuwang.wbms.mapper.RoleMapper;
import com.shuwang.wbms.service.IRoleAuthService;
import com.shuwang.wbms.service.IRoleService;
import com.shuwang.wbms.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:31
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements IRoleService {

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleAuthService roleAuthService;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean deleteById(Serializable id) {

        RoleEntity roleEntity = super.selectById(id);

        return userRoleService.delete(new EntityWrapper<UserRoleEntity>().eq("roleName", roleEntity.getRoleName()))
                && roleAuthService.delete(new EntityWrapper<RoleAuthEntity>().eq("roleName", roleEntity.getRoleName()))
                && super.deleteById(id);
    }

    @Override
    public List<RoleEntity> noneRoleList(String username) {
        return roleMapper.noneRoleList(username);
    }
}
