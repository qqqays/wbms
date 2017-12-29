package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.BackendMenuEntity;
import com.shuwang.wbms.mapper.BackendMenuMapper;
import com.shuwang.wbms.service.IBackendMenuService;
import org.springframework.stereotype.Service;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-15-2017 9:52
 */
@Service
public class BackendMenuServiceImpl
        extends ServiceImpl<BackendMenuMapper, BackendMenuEntity>
        implements IBackendMenuService{
}
