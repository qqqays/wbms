package com.shuwang.wbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Q-ays.
 * 12-10-2017 16:45
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @GetMapping
    public String news(Model model) {
        return "/display/news";
    }

    @GetMapping("/{content}")
    public String content(Model model, @PathVariable String content) {

        return "/display/news";
    }
}
