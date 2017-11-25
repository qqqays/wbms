package com.shuwang.wbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Qays
 * @createTime 2017/11/24 13:43
 */
@Controller
public class IndexController {
    @GetMapping({"","/","index"})
    public String index(){
        return "index";
    }
}
