package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.entity.SeoEntity;
import com.shuwang.wbms.entity.SplContentEntity;
import com.shuwang.wbms.entity.SysConfigEntity;
import com.shuwang.wbms.service.IDetailService;
import com.shuwang.wbms.service.IMenuService;
import com.shuwang.wbms.service.ISeoService;
import com.shuwang.wbms.service.ISplContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-20-2017 14:25
 */
@RestController
@RequestMapping("/api/upload/")
public class GeneralUpdateController {

    @Autowired
    private ISplContentService splContentService;

    @Autowired
    private IDetailService detailService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ISeoService seoService;

    @PostMapping("/info")
    public String postInfo() {

        return "";
    }

    @PostMapping("/display")
    public String postDisplay(SplContentEntity splContentEntity) {


        return splContentEntity.insert() + " insert";
    }

    @PutMapping("/seo")
    public String updateSeo(SeoEntity seoEntity) {

        return seoEntity.updateById() + " update";
    }

    @PutMapping("/sysConfig")
    public String updateSysConfig(SysConfigEntity sysConfigEntity) {

        return sysConfigEntity.updateById() + " update";

    }

}
