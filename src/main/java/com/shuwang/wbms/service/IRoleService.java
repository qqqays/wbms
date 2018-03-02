package com.shuwang.wbms.service;

import com.baomidou.mybatisplus.service.IService;
import com.shuwang.wbms.entity.RoleEntity;

import java.util.List;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:29
 */
public interface IRoleService extends IService<RoleEntity>{

    List<RoleEntity> noneRoleList(String username);
}
