package com.shuwang.wbms.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.shuwang.wbms.common.aspect.ApiAspect;
import com.shuwang.wbms.common.controller.MyController;
import com.shuwang.wbms.common.enums.ReturnCode;
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
public class SimpleUserController extends MyController{

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
        return list2JsonStr(simpleUserService.selectList(new EntityWrapper<SimpleUser>()));
    }

    @PostMapping
    public String createUser(SimpleUser user){
        return simpleUserService.insert(user) + " insert";
    }

    @GetMapping("/{name}")
    public String getUser(@PathVariable String name){
//        return list2JsonStr(simpleUserService.selectList(new EntityWrapper<SimpleUser>().eq("name",name)));
        return dataAndCode(ReturnCode.SUCCESS, simpleUserService.selectList(new EntityWrapper<SimpleUser>().eq("name",name)));
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestParam String name, @RequestParam int age){
        SimpleUser user = simpleUserService.selectById(id);
        user.setAge(age);
        user.setName(name);
        return user.updateById() + " update";
    }

    @PutMapping()
    public String updateUserEntity(SimpleUser user){
        return user.updateById() + " update";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        SimpleUser user = simpleUserService.selectById(id);
        return user.deleteById() + " delete";
    }

    @DeleteMapping()
    public String deleteUserEntity(SimpleUser user) {
        return user.deleteById() + " delete";
    }

}
