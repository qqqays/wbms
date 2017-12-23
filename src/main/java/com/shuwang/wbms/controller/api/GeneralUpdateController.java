package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.entity.*;
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

    @PutMapping("/seo")
    public String updateSeo(SeoEntity seoEntity) {

        return seoEntity.updateById() + " update";
    }

    @PutMapping("/sysConfig")
    public String updateSysConfig(SysConfigEntity sysConfigEntity) {

        return sysConfigEntity.updateById() + " update";

    }

    @PostMapping("/info")
    public String postInfo(DetailEntity detailEntity) {

        return detailEntity.insert() + " insert";
    }

    @PostMapping("/display")
    public String postDisplay(SplContentEntity splContentEntity) {

        return splContentEntity.insert() + " insert";
    }

    @PostMapping("/menu")
    public String postMenu(MenuEntity menuEntity){
        return menuEntity.insert() + " insert";
    }

    @PutMapping("/info")
    public String updateDetail(DetailEntity detailEntity) {

        return detailEntity.updateById() + " update";
    }

    @PutMapping("/display")
    public String updateSplContent(SplContentEntity splContentEntity) {
        return splContentEntity.updateById() + " update";
    }

    @PutMapping("/menu")
    public String updateMenu(MenuEntity menuEntity){
        return menuEntity.updateById() + " update";
    }

    @DeleteMapping("/info/{id}")
    public String deleteDetail(@PathVariable String id) {
        return detailService.deleteById(id) + " delete";
    }

    @DeleteMapping("/display/{id}")
    public String deleteSplContent(@PathVariable String id) {
        return splContentService.deleteById(id) + " delete";
    }

    @DeleteMapping("/menu/{id}")
    public String deleteMenu(@PathVariable String id) {
        return menuService.deleteById(id) + " delete";
    }

}
