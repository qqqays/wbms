package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shuwang.wbms.entity.SplContentEntity;
import com.shuwang.wbms.entity.MenuEntity;
import com.shuwang.wbms.service.ISplContentService;
import com.shuwang.wbms.service.IMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Q-ays.
 * 12-10-2017 13:58
 */
@Controller
@RequestMapping("/about")
public class AboutController {

    @Autowired
    private ISplContentService splContentService;

    @Autowired
    private IMenuService menuService;

    @GetMapping
    public String about(Model model) {

        MenuEntity menuEntity = menuService.selectOne(new EntityWrapper<MenuEntity>().
                eq("pid", "about").
                eq("display", 1).
                eq("deep", 1).orderBy("sort"));

        if(menuEntity == null)
            return "/display/about";

        List<SplContentEntity> splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>()
                .eq("pid", menuEntity.getId())
                .eq("state", 1));

        model.addAttribute("contents", splContentEntities);

        return "/display/about";
    }

    @GetMapping("/{content}")
    public String content(Model model, @PathVariable String content) {

        List<SplContentEntity> splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>()
                .eq("pid", content)
                .eq("state", 1));

        Iterator<SplContentEntity> it = splContentEntities.iterator();

        while (it.hasNext()) {
            SplContentEntity sce = it.next();

            if (StringUtils.isNotBlank(sce.getBannerImg())) {
                model.addAttribute("bannerImg", sce.getBannerImg());
            }
        }

        model.addAttribute("contents", splContentEntities);

        return "/display/about";
    }
}
