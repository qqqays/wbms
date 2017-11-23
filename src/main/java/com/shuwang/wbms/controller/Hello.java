package com.shuwang.wbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qays
 * @createTime 2017/11/22 16:10
 */
@Controller
public class Hello {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello, 中文字符";
    }

    @GetMapping({"","/","index"})
    public String index(){
        return "index";
    }

}
