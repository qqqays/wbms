package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shuwang.wbms.entity.MenuEntity;
import com.shuwang.wbms.entity.SimpleUser;
import com.shuwang.wbms.service.IMenuService;
import com.shuwang.wbms.service.ISimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

//    @Autowired
//    private IMenuService menuService;

    @GetMapping("/connect")
    public String connect(Model model, HttpServletRequest request){

//        List<MenuEntity> topMenus = menuService.selectList(new EntityWrapper<MenuEntity>().eq("deep",0).orderBy("sort"));
//        List<MenuEntity> subMenus1 = menuService.selectList(new EntityWrapper<MenuEntity>().eq("deep", 1).orderBy("sort"));

        List<SimpleUser> users = simpleUserService.selectList(new EntityWrapper<SimpleUser>());

//        model.addAttribute("topMenus", topMenus);
//        model.addAttribute("subMenus1", subMenus1);

        model.addAttribute("data1", "hello, freemarker");
        model.addAttribute("users", users);
        model.addAttribute("systemName", "new energy");
        return "/test/connect";
    }

}
