package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.RoleEntity;
import com.shuwang.wbms.mapper.RoleMapper;
import com.shuwang.wbms.service.IRoleAuthService;
import com.shuwang.wbms.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:31
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements IRoleService{
}
