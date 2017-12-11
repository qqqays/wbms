package com.shuwang.wbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Q-ays.
 * 12-10-2017 13:58
 */
@Controller
@RequestMapping("/about")
public class AboutController {
    @GetMapping
    public String about(Model model){
        return "/display/about";
    }

    @GetMapping("/{content}")
    public String content(Model model, @PathVariable String content) {
        return "/display/about";
    }
}
