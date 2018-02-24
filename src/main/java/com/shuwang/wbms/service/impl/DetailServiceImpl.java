package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.DetailEntity;
import com.shuwang.wbms.mapper.DetailMapper;
import com.shuwang.wbms.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Q-ays.
 * 12-11-2017 13:11
 */
@Service
public class DetailServiceImpl extends ServiceImpl<DetailMapper, DetailEntity> implements IDetailService {

    @Autowired
    private DetailMapper detailMapper;

    @Override
    public int click(String id) {
        return detailMapper.click(id);
    }
}
