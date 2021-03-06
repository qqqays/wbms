package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.*;
import com.shuwang.wbms.service.*;
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

    @Autowired
    private IProductService productService;

    @Autowired
    private ICaseService caseService;

    @GetMapping("/{topMenu:^(?!.*?\\.).*$}")
    public String top(Model model,
                      @PathVariable String topMenu,
                      @RequestParam(defaultValue = "") String s,
                      @RequestParam(defaultValue = "0") Integer pg,
                      @RequestParam(defaultValue = "8") Integer sz) {

        MenuEntity me = menuService.selectById(topMenu);

        if (me == null) {
            return "/error/500";
        }

        switch (me.getContentType()) {

            case "info":

                Page<DetailEntity> detailDatagram = datagram(detailService, pg, sz, s, topMenu);

                attrOfModel(model, detailDatagram, "/" + topMenu, s, sz);

                return "/display/generalInfoPage";

            case "display":

                List<SplContentEntity> splContentEntities;

                splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>()
                        .eq("pid", topMenu)
                        .eq("state", 1));

                if ((splContentEntities == null || splContentEntities.size() == 0) && me.isHasSub()) {
                    me = menuService.selectOne(new EntityWrapper<MenuEntity>()
                            .eq("pid", topMenu)
                            .eq("deep", 1)
                            .eq("display", 1)
                            .orderBy("sort"));
                }

                if (me != null)
                    splContentEntities = splContentService.selectList(new EntityWrapper<SplContentEntity>()
                            .eq("pid", me.getId())
                            .eq("state", 1));

                model.addAttribute("contents", splContentEntities);

                return "/display/generalSplPage";

            case "product":

                Page<ProductEntity> productDatagram = datagram4p(productService, pg, sz, s, topMenu);

                attrOfModel(model, productDatagram, "/" + topMenu, s, sz);

                return "/display/generalProductPage";

            case "case":

                Page<CaseEntity> caseDatagram = datagram4p(caseService, pg, sz, s, topMenu);

                attrOfModel(model, caseDatagram, "/" + topMenu, s, sz);

                return "/display/generalCasePage";

            default:
                return "/error/500";

        }

    }

    @GetMapping("/{topMenu}/{subMenu:^(?!.*?\\.).*$}")
    public String sub(Model model,
                      @PathVariable String topMenu,
                      @PathVariable String subMenu,
                      @RequestParam(defaultValue = "") String s,
                      @RequestParam(defaultValue = "0") Integer pg,
                      @RequestParam(defaultValue = "8") Integer sz) {

        MenuEntity me = menuService.selectById(subMenu);

        if (me == null) {
            return "/error/500";
        }

        switch (me.getContentType()) {
            case "info":

                Page<DetailEntity> detailDatagram = datagram(detailService, pg, sz, s, topMenu, subMenu);

                attrOfModel(model, detailDatagram, "/" + topMenu + "/" + subMenu, s, sz);

                return "/display/generalInfoPage";

            case "display":

                List<SplContentEntity> splContentEntities = splContentService
                        .selectList(new EntityWrapper<SplContentEntity>()
                                .eq("pid", subMenu)
                                .eq("state", 1));

                for (SplContentEntity sce : splContentEntities) {
                    if (StringUtils.isNotBlank(sce.getBannerImg())) {
                        model.addAttribute("bannerImg", sce.getBannerImg());
                    }
                }

                model.addAttribute("contents", splContentEntities);

                return "/display/generalSplPage";

            case "product":

                Page<ProductEntity> productDatagram = datagram4p(productService, pg, sz, s, topMenu, subMenu);

                attrOfModel(model, productDatagram, "/" + topMenu + "/" + subMenu, s, sz);

                return "/display/generalProductPage";

            case "case":

                Page<CaseEntity> caseDatagram = datagram4p(caseService, pg, sz, s, topMenu, subMenu);

                attrOfModel(model, caseDatagram, "/" + topMenu + "/" + subMenu, s, sz);

                return "/display/generalCasePage";

            default:
                return "/error/500";

        }

    }

    @GetMapping("/{topMenu}/{subMenu}/{id:^(?!.*?\\.).*$}")
    public String info(Model model,
                       @PathVariable String topMenu,
                       @PathVariable String subMenu,
                       @PathVariable String id,
                       @RequestParam(defaultValue = "") String s,
                       @RequestParam(defaultValue = "0") Integer pg,
                       @RequestParam(defaultValue = "8") Integer sz) {


        SeoEntity seoEntity = seoService.selectById(id);

        if (seoEntity != null) {
            model.addAttribute("seo", seoEntity);
        }

        switch (topMenu) {
            case "case":

                CaseEntity caseEntity = caseService.selectById(id);

                model.addAttribute("case", caseEntity);

                return "/display/generalCasePage";

            case "product":

                Page<ProductEntity> productDatagram = datagram4p(productService, pg, sz, s, topMenu, subMenu, id);

                attrOfModel(model, productDatagram, "/" + topMenu + "/" + subMenu + "/" + id, s, sz);

                return "/display/generalProductPage";

            default:

                DetailEntity detailEntity = detailService.selectById(id);

                detailService.click(id);

                model.addAttribute("detail", detailEntity);

                return "/display/generalInfoPage";
        }

    }

    @GetMapping("/{topMenu}/{subMenu}/{type}/{id:^(?!.*?\\.).*$}")
    public String treble(@PathVariable String topMenu,
                         @PathVariable String subMenu,
                         @PathVariable String type,
                         @PathVariable String id) {

        if (topMenu.equals("product")) {

            ProductEntity productEntity = productService.selectById(id);

//            model.addAttribute("product", productEntity);

            return "/display/static/" + productEntity.getPage();
        }

        return "/error/500";

    }
}
