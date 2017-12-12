package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shuwang.wbms.entity.SplContentEntity;
import com.shuwang.wbms.entity.MenuEntity;
import com.shuwang.wbms.service.ISplContentService;
import com.shuwang.wbms.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String about(Model model){

        MenuEntity menuEntity = menuService.selectOne(new EntityWrapper<MenuEntity>().eq("pid", "about").eq("deep",1).orderBy("sort"));

        List<SplContentEntity> splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>().eq("pid", menuEntity.getId()).eq("state", 1));

        model.addAttribute("contents", splContentEntities);

        return "/display/about";
    }

    @GetMapping("/{content}")
    public String content(Model model, @PathVariable String content) {

        List<SplContentEntity> splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>().eq("pid", content).eq("state", 1));

        model.addAttribute("contents", splContentEntities);

        return "/display/about";
    }
}
