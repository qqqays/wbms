package com.shuwang.wbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-16-2018 13:45
 */
@Controller
@RequestMapping("template")
public class TemplateController {
    @GetMapping()
    public String template() {
        return "template";
    }

    @GetMapping("/templateSub")
    public String sub() {
        return "template";
    }

}
