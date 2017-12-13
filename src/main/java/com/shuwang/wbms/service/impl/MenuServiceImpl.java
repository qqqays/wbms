package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.MenuEntity;
import com.shuwang.wbms.mapper.MenuMapper;
import com.shuwang.wbms.service.IMenuService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qays
 * @createTime 2017/11/25 16:48
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements IMenuService{

    @Cacheable(value = "menuCache", key="#p0")
    @Override
    public List<MenuEntity> selectList(Wrapper<MenuEntity> wrapper) {
        return super.baseMapper.selectList(wrapper);
    }
}
