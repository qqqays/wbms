package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.PageController;
import com.shuwang.wbms.entity.DetailEntity;
import com.shuwang.wbms.service.IDetailService;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.INACTIVE;
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
 * 12-10-2017 16:45
 */
@Controller
@RequestMapping("/news")
public class NewsController extends PageController{

    @Autowired
    private IDetailService detailService;

    @GetMapping
    public String news(Model model, @RequestParam(defaultValue = "") String s, @RequestParam(defaultValue = "0") Integer pg, @RequestParam(defaultValue = "1") Integer sz) {

        Page<DetailEntity> detailDatagram = datagram(detailService, pg, sz, s, "news");

        attrOfModel(model, detailDatagram, "/news", s, sz);

        return "/display/news";
    }

    @GetMapping("/{content}")
    public String content(Model model,@RequestParam(defaultValue = "") String s, @RequestParam(defaultValue = "0") Integer pg, @RequestParam(defaultValue = "1") Integer sz, @PathVariable String content) {

//        List<DetailEntity> detailEntities = detailService.selectList(new EntityWrapper<DetailEntity>().eq("class1", "news").eq("class2", content).orderBy("updateTime", false));

        Page<DetailEntity> detailDatagram = datagram(detailService, pg, sz, s, "news", content);

        attrOfModel(model, detailDatagram, "/news/" + content, s, sz);

        return "/display/news";
    }

    @GetMapping("/{content}/{id}")
    public String detail(Model model, @PathVariable String content, @PathVariable String id) {

        DetailEntity detailEntity = detailService.selectById(id);

        model.addAttribute("detail", detailEntity);

        return "/display/news";
    }
}
