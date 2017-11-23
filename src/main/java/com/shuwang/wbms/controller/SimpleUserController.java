package com.shuwang.wbms.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.shuwang.wbms.entity.SimpleUser;
import com.shuwang.wbms.service.ISimpleUserService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Qays
 * @createTime 2017/11/23 10:10
 */
@Controller
@RequestMapping("/user")
public class SimpleUserController {

    @Autowired
    private ISimpleUserService simpleUserService;

    @GetMapping("/get/{name}")
    @ResponseBody
    public String getUsers(@PathVariable String name){
        return new JSONArray(simpleUserService.selectList(new EntityWrapper<SimpleUser>().eq("name",name))).toString();
    }

    @PostMapping("/add")
    @ResponseBody
    public String create(@RequestParam String name, @RequestParam int age){
        SimpleUser user = new SimpleUser();
//        user.setName("luguo");
//        user.setAge(18);

        return simpleUserService.insert(user) + "insert";
    }

    @PutMapping("/update")
    @ResponseBody
    public String update(){
        return "null";
    }
}
