package com.shuwang.wbms.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * Created by Q-ays.
 * 12-08-2017 11:25
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;

    @GetMapping("freemarker")
    public String freemarkerConfig(){
        String before = freeMarkerConfigurer.getConfiguration().getTemplateLoader().toString();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/123");
        String after = freeMarkerConfigurer.getConfiguration().getTemplateLoader().toString();

        return "before: " + before + "\n" + "after: " + after;
    }
}
