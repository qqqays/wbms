package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.*;
import com.shuwang.wbms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-14-2017 13:56
 */

@Controller
@RequestMapping("/backend")
public class BackendController extends ProController {

    @Autowired
    private ISysConfigService sysConfigService;

    @Autowired
    private ISeoService seoService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ISplContentService splContentService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private IDetailService detailService;

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



    @GetMapping("/{content}")
    public String common(Model model, @PathVariable String content) {

        List<MenuEntity> menuEntities = menuService.selectList(new EntityWrapper<MenuEntity>().orderBy("sort"));
        model.addAttribute("allMenus", menuEntities);
        return "/edit/" + content;
    }

    @GetMapping("/{content}/{id}")
    public String menu(Model model, @PathVariable String content, @PathVariable String id) {

        List<MenuEntity> menuEntities = menuService.selectList(new EntityWrapper<MenuEntity>().orderBy("sort"));

        switch (content) {
            case "e-menu":
                MenuEntity me = menuService.selectById(id);
                model.addAttribute("menu", me);
                break;
            case "e-images":
                ImageEntity ie = imageService.selectById(id);
                model.addAttribute("image", ie);
                break;
            case "p-display":
                SplContentEntity sce = splContentService.selectById(id);
                model.addAttribute("display", sce);
                break;
            case "p-information":
                DetailEntity de = detailService.selectById(id);
                model.addAttribute("info", de);
            default:
                break;
        }

        model.addAttribute("allMenus", menuEntities);
        return "/edit/" + content;
    }
}
