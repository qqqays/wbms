package com.shuwang.wbms.common.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-12-2017 17:20
 */
public class PageController {

    /**
     * Gains the list of details
     *
     * @param iService
     * @param pageNumber
     * @param pageSize
     * @param search
     * @param type
     * @param <T>
     * @return
     */
    public <T> Page<T> datagram(IService<T> iService, Integer pageNumber, Integer pageSize, String search, String... type) {
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

    /**
     * Add attribute to model
     *
     * @param model
     * @param detailDatagram
     * @param actionUrl
     * @param search
     * @param pageSize
     */
    public void attrOfModel(Model model, Page detailDatagram, String actionUrl, String search, Integer pageSize) {
        model.addAttribute("detailDatagram", detailDatagram);
        model.addAttribute("actionUrl", actionUrl);

        if (StringUtils.isNotBlank(search)) {
            model.addAttribute("s", "&s=" + search);
        }

        if (pageSize > 0) {
            model.addAttribute("sz", "&sz" + pageSize);
        }
    }
}
