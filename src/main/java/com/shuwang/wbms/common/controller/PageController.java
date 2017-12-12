package com.shuwang.wbms.common.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.shuwang.wbms.service.IDetailService;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-12-2017 17:20
 */
public class PageController {

    public <T> Page<T> datagram(IService iService, Integer pageNumber, Integer pageSize, String search, String... type) {
        Page<T> page = new Page<>(pageNumber, pageSize);
        page.setOrderByField("updateTime");
        page.setAsc(false);

        EntityWrapper<T> ew = new EntityWrapper<>();

        for(int i = 0; i < type.length; i++) {
            ew.eq("class" + (i + 1), type[i]);
        }

        if (StringUtils.isNotBlank(search)) {
            ew.andNew().like("description", search).or().like("title", search);
        }

        ew.orderBy("updateTime", false);

        return iService.selectPage(page, ew);
    }
}
