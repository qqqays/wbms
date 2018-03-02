package com.shuwang.wbms.service;

import com.baomidou.mybatisplus.service.IService;
import com.shuwang.wbms.entity.UserEntity;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:28
 */
public interface IUserService extends IService<UserEntity>{

    boolean updateProfile(String newName, String desc, String avadar, String originName);

    boolean updateProfile(UserEntity now, UserEntity origin);
}
