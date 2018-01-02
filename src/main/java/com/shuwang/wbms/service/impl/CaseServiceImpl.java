package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.CaseEntity;
import com.shuwang.wbms.mapper.CaseMapper;
import com.shuwang.wbms.service.ICaseService;
import org.springframework.stereotype.Service;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-02-2018 16:10
 */
@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, CaseEntity> implements ICaseService{
}
