package com.shuwang.wbms.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shuwang.wbms.entity.*;
import com.shuwang.wbms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 02-27-2018 10:54
 */
@RestController
@RequestMapping("/api/manager")
public class UserManageController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAuthService authService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleAuthService roleAuthService;

    //    user
    @PostMapping("/user")
    public String createUser(UserEntity userEntity) {
        return userEntity.insert() + " insert";
    }

    @DeleteMapping("/user")
    public String deleteUser(String id) {
        return userService.deleteById(id) + " delete";
    }

    //    role
    @PostMapping("/role")
    public String createRole(RoleEntity roleEntity) {
        return roleEntity.insert() + " insert";
    }

    @DeleteMapping("/role")
    public String deleteRole(String id){
        return roleService.deleteById(id) + " delete";
    }

    //    auth
    @PostMapping("/authorities")
    public String createAuth(AuthEntity authEntity) {
        return authEntity.insert() + " insert";
    }

    @DeleteMapping("/authorities")
    public String deleteAuth(String id){
        return authService.deleteById(id) + " delete";
    }

    //    user-role
    @PostMapping("/user-role")
    public String createUserRole(UserRoleEntity userRoleEntity) {
        return userRoleEntity.insert() + " insert";
    }

    //    role-authorities
    @PostMapping("/role-auth")
    public String createRoleAuth(RoleAuthEntity roleAuthEntity) {
        return roleAuthEntity.insert() + " insert";
    }
}
