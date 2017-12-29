package com.shuwang.wbms.service;

import com.baomidou.mybatisplus.service.IService;
import com.shuwang.wbms.entity.RoleAuthEntity;

import java.util.Set;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:29
 */
public interface IRoleAuthService extends IService<RoleAuthEntity>{

    /**
     * 通过 role set 查找角色 所有 权限
     *
     * @param set
     * @return
     */
    Set<String> findPermBySet(Set<String> set);
}
