package com.shuwang.wbms.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.*;
import com.shuwang.wbms.mapper.RoleMapper;
import com.shuwang.wbms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 02-27-2018 10:54
 */
@RestController
@RequestMapping("/api/manager")
public class UserManageController extends ProController{

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
    @GetMapping("/users")
    public String getUsers(@RequestParam(defaultValue = "0") Integer pageNumber){

        Page<UserEntity> uGram = datagram(userService, pageNumber, "userName");

        return page2JsonStr(uGram);
    }

    @PostMapping("/users")
    public String createUser(UserEntity userEntity) {
        return userEntity.insert() + " insert";
    }

    @DeleteMapping("/users/{username}")
    public String deleteUser(@PathVariable String username) {
        return userService.deleteById(username) + " delete";
    }

    @PutMapping("/users")
    public String updateUser(UserEntity userEntity){
        return userEntity.updateById() + " update";
    }

    //    role
    @GetMapping("/roles")
    public String getRoles(@RequestParam(defaultValue = "0") Integer pageNumber) {
        Page<RoleEntity> rGram = datagram(roleService, pageNumber, "roleName");

        return page2JsonStr(rGram);
    }

    @PostMapping("/roles")
    public String createRole(RoleEntity roleEntity) {
        return roleEntity.insert() + " insert";
    }

    @DeleteMapping("/roles/{roleName}")
    public String deleteRole(@PathVariable String roleName) {
        return roleService.deleteById(roleName) + " delete";
    }

    //    auth
    @GetMapping("/authorities")
    public String getAuthorities(@RequestParam(defaultValue = "0") Integer pageNumber){
        Page<AuthEntity> aGram = datagram(authService, pageNumber);

        return page2JsonStr(aGram);
    }

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
    public String createUserRole(@RequestBody List<UserRoleEntity> userRoleEntities) {
        return userRoleService.insertBatch(userRoleEntities) + " insert";
    }

    @DeleteMapping("/user-role/{id}")
    public String deleteUserRole(@PathVariable String id) {
        return userRoleService.deleteById(id) + " delete";
    }

    @DeleteMapping("/user-role")
    public String deleteUserRoles(@RequestParam String user, @RequestParam String role) {
        return userRoleService.delete(new EntityWrapper<UserRoleEntity>().eq("userName", user).
                and().eq("roleName", role)) + " delete";
    }

    //    role-authorities
    @PostMapping("/role-auth")
    public String createRoleAuth(List<RoleAuthEntity> roleAuthEntities) {
        return roleAuthService.insertBatch(roleAuthEntities) + " insert";
    }

    @DeleteMapping("/role-auth/{id}")
    public String deleteRoleAuth(@PathVariable String id) {
        return roleAuthService.deleteById(id) + " delete";
    }

    @DeleteMapping("/role-auth")
    public String deleteRoleAuths(@RequestParam String role, @RequestParam String auth) {
        return roleAuthService.delete(new EntityWrapper<RoleAuthEntity>().eq("roleName", role)
                .and().eq("authName", auth)) + " delete";
    }

}
