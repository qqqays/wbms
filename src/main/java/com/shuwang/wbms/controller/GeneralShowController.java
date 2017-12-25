package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.DetailEntity;
import com.shuwang.wbms.entity.MenuEntity;
import com.shuwang.wbms.entity.SeoEntity;
import com.shuwang.wbms.entity.SplContentEntity;
import com.shuwang.wbms.service.IDetailService;
import com.shuwang.wbms.service.IMenuService;
import com.shuwang.wbms.service.ISeoService;
import com.shuwang.wbms.service.ISplContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
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
    public String top(Model model, @PathVariable String topMenu, @RequestParam(defaultValue = "") String s, @RequestParam(defaultValue = "0") Integer pg, @RequestParam(defaultValue = "5") Integer sz) {

        MenuEntity me = menuService.selectById(topMenu);

        if (me == null) {
            return "";
        }

        if (me.getContentType().equals("info")) {

            Page<DetailEntity> detailDatagram = datagram(detailService, pg, sz, s, topMenu);

            attrOfModel(model, detailDatagram, "/" + topMenu, s, sz);

            return "/display/generalInfoPage";

        } else if (me.getContentType().equals("display")) {

            List<SplContentEntity> splContentEntities;

            splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>().eq("pid", topMenu).eq("state", 1));

            if (splContentEntities == null && me.isHasSub()) {
                me = menuService.selectOne(new EntityWrapper<MenuEntity>().eq("pid", topMenu).eq("deep", 1).orderBy("sort"));
            }

            if (me != null)
                splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>().eq("pid", me.getId()).eq("state", 1));

            model.addAttribute("contents", splContentEntities);

            return "/display/generalSplPage";

        } else {
            return "";

        }
    }

    @GetMapping("/{topMenu}/{subMenu:^(?!.*?\\.).*$}")
    public String sub(Model model, @PathVariable String topMenu, @PathVariable String subMenu, @RequestParam(defaultValue = "") String s, @RequestParam(defaultValue = "0") Integer pg, @RequestParam(defaultValue = "5") Integer sz) {

        MenuEntity me = menuService.selectById(subMenu);

        if (me.getContentType().equals("info")) {

            Page<DetailEntity> detailDatagram = datagram(detailService, pg, sz, s, topMenu, subMenu);

            attrOfModel(model, detailDatagram, "/"+ topMenu +"/" + subMenu, s, sz);

            return "/display/generalInfoPage";

        } else if (me.getContentType().equals("display")) {

            List<SplContentEntity> splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>().eq("pid", subMenu).eq("state", 1));

            Iterator<SplContentEntity> it = splContentEntities.iterator();

            while (it.hasNext()) {
                SplContentEntity sce = it.next();

                if (StringUtils.isNotBlank(sce.getBannerImg())) {
                    model.addAttribute("bannerImg", sce.getBannerImg());
                }
            }

            model.addAttribute("contents", splContentEntities);

            return "/display/generalSplPage";
        } else {
            return "";
        }

    }

    @GetMapping("/{topMenu}/{subMenu}/{id:^(?!.*?\\.).*$}")
    public String info(Model model, @PathVariable String topMenu, @PathVariable String subMenu, @PathVariable String id) {

        DetailEntity detailEntity = detailService.selectById(id);

        SeoEntity seoEntity = seoService.selectById(id);

        if (seoEntity != null) {
            model.addAttribute("seo", seoEntity);
        }

        model.addAttribute("detail", detailEntity);

        return "/display/generalInfoPage";
    }
}
