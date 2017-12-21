package com.shuwang.wbms.controller.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.DetailEntity;
import com.shuwang.wbms.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-21-2017 11:36
 */
@RestController
@RequestMapping("/api/details")
public class DetailController extends ProController{

    @Autowired
    private IDetailService detailService;

    @GetMapping
    public String details(@RequestParam(defaultValue = "0") Integer pageNumber) {
            Page<DetailEntity> infoGram = datagram(detailService, pageNumber);
        return page2JsonStr(infoGram);
    }
}
