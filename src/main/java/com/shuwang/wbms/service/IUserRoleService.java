package com.shuwang.wbms.service;

import com.baomidou.mybatisplus.service.IService;
import com.shuwang.wbms.entity.UserRoleEntity;

import java.util.Set;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:29
 */
public interface IUserRoleService extends IService<UserRoleEntity>{
    /**
     * 获取用户的角色
     * @param userName of string
     * @return set
     */
    Set<String> findRolesByUid(String userName);

}
