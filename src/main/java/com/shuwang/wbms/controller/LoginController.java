package com.shuwang.wbms.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 13:21
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login() {
        return "/login";
    }

    @PostMapping("/authentication")
    public String authenticator(@RequestParam String userName, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            subject.login(token);
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("fuck");
            e.printStackTrace();
        }

        return "redirect:/backend";
    }


}
