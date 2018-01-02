package com.shuwang.wbms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.shuwang.wbms.entity.ProductEntity;
import com.shuwang.wbms.mapper.ProductMapper;
import com.shuwang.wbms.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-02-2018 16:10
 */
@Service
public class ProductImpl extends ServiceImpl<ProductMapper, ProductEntity> implements IProductService{
}
