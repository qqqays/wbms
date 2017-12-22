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
        String[] searchColumn = {"description", "title"};
        return datagram(iService, pageNumber, pageSize, search, "updateDate", searchColumn, type);
    }

    /**
     * Base function for list of entity
     *
     * @param iService
     * @param pageNumber
     * @param pageSize
     * @param search
     * @param order
     * @param searchColumn
     * @param type
     * @param <T>
     * @return
     */
    public <T> Page<T> datagram(IService<T> iService, Integer pageNumber, Integer pageSize, String search, String order, String[] searchColumn, String... type) {
        Page<T> page = new Page<>(pageNumber, pageSize);
        page.setOrderByField(order);
        page.setAsc(false);

        EntityWrapper<T> ew = new EntityWrapper<>();

        for(int i = 0; i < type.length; i++) {
            ew.eq("class" + (i + 1), type[i]);
        }

        if (StringUtils.isNotBlank(search)) {
            if (searchColumn.length > 0) {
                ew.andNew();
                int i = 0;
                for(; i < searchColumn.length - 1; i++) {
                    ew.like(searchColumn[i], search).or();
                }
                ew.like(searchColumn[i], search);
            }
        }

        ew.orderBy(order , false);

        return iService.selectPage(page, ew);
    }

    /**
     * Simple struct for gaining entity of list.
     * Orders by id, page size equ 15, null of search, null of type.
     * @param iService
     * @param pageNumber
     * @param <T>
     * @return
     */
    public <T> Page<T> datagram(IService<T> iService, Integer pageNumber) {
        String[] fuck = {};
        return datagram(iService, pageNumber, 15, "", "id", fuck);
    }

    /**
     * Adds list of detail attribute to model
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
            model.addAttribute("sz", "&sz=" + pageSize);
        }
    }
}
