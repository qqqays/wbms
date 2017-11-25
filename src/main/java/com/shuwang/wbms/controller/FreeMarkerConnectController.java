package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shuwang.wbms.entity.SimpleUser;
import com.shuwang.wbms.service.ISimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Qays
 * @createTime 2017/11/24 13:38
 */

@Controller
@RequestMapping("/freemarker")
public class FreeMarkerConnectController {

    @Autowired
    private ISimpleUserService simpleUserService;

    @GetMapping("/connect")
    public String connect(Model model){
        List<SimpleUser> users = simpleUserService.selectList(new EntityWrapper<SimpleUser>());
        model.addAttribute("data1", "hello, freemarker");
        model.addAttribute("users", users);
        model.addAttribute("systemName", "new energy");
        return "/test/connect";
    }
}
