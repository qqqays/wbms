package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.shuwang.wbms.entity.SeoEntity;
import com.shuwang.wbms.entity.SysConfigEntity;
import com.shuwang.wbms.service.ISeoService;
import com.shuwang.wbms.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-14-2017 13:56
 */

@Controller
@RequestMapping("/backend")
public class BackendController {

    @Autowired
    private ISysConfigService sysConfigService;

    @Autowired
    private ISeoService seoService;

    Wrapper<SysConfigEntity> sysConfigEntityWrapper = new EntityWrapper<SysConfigEntity>();

    @GetMapping
    public String backend(Model model) {


        return "/edit/backend";
    }

    @GetMapping("/sysConfig")
    public String content(Model model) {

        SysConfigEntity sysConfigEntity = sysConfigService.selectOne(sysConfigEntityWrapper);

        SeoEntity seoEntity = seoService.selectById("system");

        model.addAttribute("sysConfig", sysConfigEntity);
        model.addAttribute("seoConfig", seoEntity);

        return "/edit/sysConfig";
    }

    @PutMapping("/seo")
    @ResponseBody
    public String updateSeo(SeoEntity seoEntity) {

        return seoEntity.updateById() + " update";
    }

    @PutMapping("/sysConfig")
    @ResponseBody
    public String updateSysConfig(SysConfigEntity sysConfigEntity) {

        return sysConfigEntity.updateById() + " update";

    }
}
