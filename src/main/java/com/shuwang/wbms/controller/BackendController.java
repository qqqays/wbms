package com.shuwang.wbms.controller;

import com.shuwang.wbms.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-14-2017 13:56
 */

@Controller
@RequestMapping("/backend")
public class BackendController {

    @Autowired
    private ISysConfigService sysConfigService;

    @GetMapping("/{content}")
    public String content(Model model, @PathVariable String content) {



        return "/edit/" + content;
    }
}
