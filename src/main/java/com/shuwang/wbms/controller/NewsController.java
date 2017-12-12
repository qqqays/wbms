package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shuwang.wbms.entity.DetailEntity;
import com.shuwang.wbms.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Q-ays.
 * 12-10-2017 16:45
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private IDetailService detailService;

    @GetMapping
    public String news(Model model) {
        return "/display/news";
    }

    @GetMapping("/{content}")
    public String content(Model model, @PathVariable String content) {

        List<DetailEntity> detailEntities = detailService.selectList(new EntityWrapper<DetailEntity>().eq("class1", "news").eq("class2", content).orderBy("updateDate", false));

        model.addAttribute("detailList", detailEntities);

        return "/display/news";
    }
}
