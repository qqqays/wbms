package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.CaseEntity;
import com.shuwang.wbms.entity.DetailEntity;
import com.shuwang.wbms.entity.ProductEntity;
import com.shuwang.wbms.service.ICaseService;
import com.shuwang.wbms.service.IDetailService;
import com.shuwang.wbms.service.IProductService;
import com.sun.org.apache.bcel.internal.generic.INEG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Qays
 * @createTime 2017/11/24 13:43
 */
@Controller
public class IndexController extends ProController{

    @Autowired
    private IProductService productService;

    @Autowired
    private ICaseService caseService;

    @Autowired
    private IDetailService detailService;

    @GetMapping({"","/","index"})
    public String index(Model model){

        Page<DetailEntity> detailDatagram = datagram(detailService, 1, 4, "");

        Page<ProductEntity> productDatagram = datagram4p(productService, 1, 3, "", "product");

        Page<CaseEntity> caseDatagram = datagram4p(caseService, 1, 4, "", "case");

        model.addAttribute("news", detailDatagram);
        model.addAttribute("products", productDatagram);
        model.addAttribute("cases", caseDatagram);

        return "index";
    }
}
