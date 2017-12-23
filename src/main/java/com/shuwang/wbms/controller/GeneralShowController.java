package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.DetailEntity;
import com.shuwang.wbms.entity.MenuEntity;
import com.shuwang.wbms.entity.SplContentEntity;
import com.shuwang.wbms.service.IDetailService;
import com.shuwang.wbms.service.IMenuService;
import com.shuwang.wbms.service.ISeoService;
import com.shuwang.wbms.service.ISplContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-20-2017 13:28
 */
@Controller
@RequestMapping
public class GeneralShowController extends ProController {

    @Autowired
    private ISplContentService splContentService;

    @Autowired
    private IDetailService detailService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ISeoService seoService;

    @GetMapping("/{topMenu:^(?!.*?\\.).*$}")
    public String top(Model model, @PathVariable String topMenu, @RequestParam(defaultValue = "") String s, @RequestParam(defaultValue = "0") Integer pg, @RequestParam(defaultValue = "1") Integer sz) {

        MenuEntity me = menuService.selectById(topMenu);

        if (me == null) {
            return "";
        }

        if (me.getContentType().equals("info")) {

            Page<DetailEntity> detailDatagram = datagram(detailService, pg, sz, s, topMenu);

            attrOfModel(model, detailDatagram, "/" + topMenu, s, sz);

            return "/display/" + topMenu;

        } else if (me.getContentType().equals("display")) {

            if (me.isHasSub()) {
                me = menuService.selectOne(new EntityWrapper<MenuEntity>().eq("pid", topMenu).eq("deep", 1).orderBy("sort"));
            }

            List<SplContentEntity> splContentEntities = null;
            if (me != null)
              splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>().eq("pid", me.getId()).eq("state", 1));

            model.addAttribute("contents", splContentEntities);

//            return "/display/" + topMenu;
            return "/display/generalSplPage";

        } else {
            return "";

        }
    }

    @GetMapping("/{topMenu}/{subMenu:^(?!.*?\\.).*$}")
    public String sub(Model model, @PathVariable String topMenu, @PathVariable String subMenu, @RequestParam(defaultValue = "") String s, @RequestParam(defaultValue = "0") Integer pg, @RequestParam(defaultValue = "1") Integer sz) {
        return "";
    }

    @GetMapping("/{topMenu}/{subMenu}/{id:^(?!.*?\\.).*$}")
    public String info(Model model, @PathVariable String topMenu, @PathVariable String subMenu, @PathVariable String id) {
        return "";
    }
}
