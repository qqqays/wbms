package com.shuwang.wbms.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.shuwang.wbms.common.aspect.ApiAspect;
import com.shuwang.wbms.entity.SimpleUser;
import com.shuwang.wbms.service.ISimpleUserService;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

/**
 * @author Qays
 * @createTime 2017/11/23 10:10
 */
@RestController
@RequestMapping("/api/users")
public class SimpleUserController {

    private static final Logger logger = LoggerFactory.getLogger(SimpleUserController.class);

    @Autowired
    private ISimpleUserService simpleUserService;

//    @Cacheable(value = "testCache", key = "#param")
    @GetMapping("/cache")
    public String cache(){
        return simpleUserService.cacheTest();
    }

    @GetMapping("/clear")
    public String clearCache(){
        return simpleUserService.clearCache();
    }



    @GetMapping
    public String getUsers() {
        return new JSONArray(simpleUserService.selectList(new EntityWrapper<SimpleUser>())).toString();
    }

    @PostMapping
    public String createUser(@RequestParam String name, @RequestParam int age){
        SimpleUser user = new SimpleUser(name, age);
//        user.setName("luguo");
//        user.setAge(18);

//        System.out.println(name);
//        System.out.println(age);
        return simpleUserService.insert(user) + " insert";
    }

    @GetMapping("/{name}")
    public String getUser(@PathVariable String name){
        return new JSONArray(simpleUserService.selectList(new EntityWrapper<SimpleUser>().eq("name",name))).toString();
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestParam String name, @RequestParam int age){
        SimpleUser user = simpleUserService.selectById(id);
        user.setAge(age);
        user.setName(name);
//        simpleUserService.updateById(user);
        return user.updateById() + " update";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        SimpleUser user = simpleUserService.selectById(id);
        return user.deleteById() + " delete";
    }

}
