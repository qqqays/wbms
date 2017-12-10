package com.shuwang.wbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Q-ays.
 * 12-10-2017 17:18
 */
@Controller
@RequestMapping("/case")
public class CaseController {

    @GetMapping
    public String cases(Model model){
        return "/display/cases";
    }
}
