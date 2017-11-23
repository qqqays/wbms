package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.SimpleUser;
import com.shuwang.wbms.mapper.SimpleUserMapper;
import com.shuwang.wbms.service.ISimpleUserService;
import org.springframework.stereotype.Service;

/**
 * @author Qays
 * @createTime 2017/11/23 10:06
 */
@Service
public class SimpleUserServiceImpl extends ServiceImpl<SimpleUserMapper, SimpleUser> implements ISimpleUserService {
}
