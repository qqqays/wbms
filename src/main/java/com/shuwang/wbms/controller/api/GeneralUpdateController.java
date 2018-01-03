package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.entity.*;
import com.shuwang.wbms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-20-2017 14:25
 */
@RestController
@RequestMapping("/api/upload/")
public class GeneralUpdateController {

    @Autowired
    private ISplContentService splContentService;

    @Autowired
    private IDetailService detailService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICaseService caseService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ISeoService seoService;

//    seo
    @PutMapping("/seo")
    public String updateSeo(SeoEntity seoEntity) {

        return seoEntity.updateById() + " update";
    }

//    sysConfig
    @PutMapping("/sysConfig")
    public String updateSysConfig(SysConfigEntity sysConfigEntity) {

        return sysConfigEntity.updateById() + " update";

    }

//    information
    @PostMapping("/info")
    public String postInfo(DetailEntity detailEntity) {

        return detailEntity.insert() + " insert";
    }

    @DeleteMapping("/info/{id}")
    public String deleteDetail(@PathVariable String id) {
        return detailService.deleteById(id) + " delete";
    }

    @PutMapping("/info")
    public String updateDetail(DetailEntity detailEntity) {

        return detailEntity.updateById() + " update";
    }

//    display
    @PostMapping("/display")
    public String postDisplay(SplContentEntity splContentEntity) {

        return splContentEntity.insert() + " insert";
    }

    @PutMapping("/display")
    public String updateSplContent(SplContentEntity splContentEntity) {
        return splContentEntity.updateById() + " update";
    }

    @DeleteMapping("/display/{id}")
    public String deleteSplContent(@PathVariable String id) {
        return splContentService.deleteById(id) + " delete";
    }

//    menu
    @PostMapping("/menu")
    public String postMenu(MenuEntity menuEntity){
        return menuEntity.insert() + " insert";
    }

    @PutMapping("/menu")
    public String updateMenu(MenuEntity menuEntity){
        return menuEntity.updateById() + " update";
    }

    @DeleteMapping("/menu/{id}")
    public String deleteMenu(@PathVariable String id) {
        return menuService.deleteById(id) + " delete";
    }

//    product
    @PostMapping("/product")
    public String postProduct(ProductEntity productEntity) {
        return productEntity.insert() + " insert";
    }

    @PutMapping("/product")
    public String updateProduct(ProductEntity productEntity) {
        return productEntity.updateById() + " update";
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable String id) {
        return productService.deleteById(id) + " delete";
    }

//    case
    @PostMapping("/case")
    public String postCase(CaseEntity caseEntity) {
        return caseEntity.insert() + " insert";
    }

    @PutMapping("/case")
    public String updateCase(CaseEntity caseEntity) {
        return caseEntity.insert() + " insert";
    }

    @DeleteMapping("/case/{id}")
    public String deleteCase(@PathVariable String id){
        return caseService.deleteById(id) + " delete";
    }

}
