package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.SeoEntity;
import com.shuwang.wbms.mapper.SeoMapper;
import com.shuwang.wbms.service.ISeoService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Q-ays.
 * 12-11-2017 13:37
 */
@Service
public class SeoServiceImpl extends ServiceImpl<SeoMapper, SeoEntity> implements ISeoService {

    @Cacheable(value = "seoCache", key="#p0")
    @Override
    public SeoEntity selectById(Serializable id) {
        return super.baseMapper.selectById(id);
    }
}
