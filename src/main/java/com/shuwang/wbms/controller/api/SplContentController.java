package com.shuwang.wbms.controller.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.SplContentEntity;
import com.shuwang.wbms.service.ISplContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-21-2017 11:23
 */

@RestController
@RequestMapping("/api/splContents")
public class SplContentController extends ProController{

    @Autowired
    private ISplContentService splContentService;

    @GetMapping
    public String  contents(@RequestParam(defaultValue = "0") Integer pageNumber) {

        Page<SplContentEntity> dplGram = datagram(splContentService, pageNumber);

        return page2JsonStr(dplGram);
    }
}
