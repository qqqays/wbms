package com.shuwang.wbms.controller.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.*;
import com.shuwang.wbms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Just for backend
 *
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-25-2017 8:57
 */
@RestController
@RequestMapping("/api/gains/")
public class GeneralGetController extends ProController{
    @Autowired
    private IDetailService detailService;

    @Autowired
    private ISplContentService splContentService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICaseService caseService;

    @Autowired
    private IMenuService menuService;

    @GetMapping("/details")
    public String details(@RequestParam(defaultValue = "0") Integer pageNumber) {
        Page<DetailEntity> infoGram = datagram(detailService, pageNumber);
        return page2JsonStr(infoGram);
    }

    @GetMapping("/splContents")
    public String  contents(@RequestParam(defaultValue = "0") Integer pageNumber) {

        Page<SplContentEntity> dplGram = datagram(splContentService, pageNumber);

        return page2JsonStr(dplGram);
    }

    @GetMapping("/products")
    public String products(@RequestParam(defaultValue = "0") Integer pageNumber) {
        Page<ProductEntity> pdtGram = datagram(productService, pageNumber);
        return page2JsonStr(pdtGram);
    }

    @GetMapping("/cases")
    public String cases(@RequestParam(defaultValue = "0") Integer pageNumber) {
        Page<CaseEntity> csGram = datagram(caseService, pageNumber);
        return page2JsonStr(csGram);
    }

    @GetMapping("/menus")
    public String menus(@RequestParam(defaultValue = "0") Integer pageNumber) {

        Page<MenuEntity> menuGram = datagram(menuService, pageNumber, "sort");
        return page2JsonStr(menuGram);
    }

}
