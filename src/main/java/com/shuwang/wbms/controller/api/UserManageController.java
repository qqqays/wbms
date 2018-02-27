package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.entity.*;
import com.shuwang.wbms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/user/{username}")
    public String deleteUser(@PathVariable String username) {
        return userService.deleteById(username) + " delete";
    }

    //    role
    @PostMapping("/role")
    public String createRole(RoleEntity roleEntity) {
        return roleEntity.insert() + " insert";
    }

    @DeleteMapping("/role/{roleName}")
    public String deleteRole(@PathVariable String roleName) {
        return roleService.deleteById(roleName) + " delete";
    }

    //    auth
    @PostMapping("/authorities")
    public String createAuth(AuthEntity authEntity) {
        return authEntity.insert() + " insert";
    }

    @DeleteMapping("/authorities/{authName}")
    public String deleteAuth(@PathVariable String authName) {
        return authService.deleteById(authName) + " delete";
    }

    //    user-role
    @PostMapping("/user-role")
    public String createUserRole(UserRoleEntity userRoleEntity) {
        return userRoleEntity.insert() + " insert";
    }

    @DeleteMapping("/user-role/{id}")
    public String deleteUserRole(@PathVariable String id) {
        return userRoleService.deleteById(id) + " delete";
    }

    //    role-authorities
    @PostMapping("/role-auth")
    public String createRoleAuth(RoleAuthEntity roleAuthEntity) {
        return roleAuthEntity.insert() + " insert";
    }

    @DeleteMapping("/role-auth/{id}")
    public String deleteRoleAuth(@PathVariable String id) {
        return roleAuthService.deleteById(id) + " delete";
    }
}
