package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.AuthEntity;
import com.shuwang.wbms.mapper.AuthMapper;
import com.shuwang.wbms.service.IAuthService;
import org.springframework.stereotype.Service;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 10:31
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, AuthEntity> implements IAuthService{
}
