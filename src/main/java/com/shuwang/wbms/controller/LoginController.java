package com.shuwang.wbms.controller;

import com.google.code.kaptcha.servlet.KaptchaExtend;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.security.MyRealm1;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 13:21
 */
@Controller
public class LoginController extends ProController{

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/authentication")
    public String authenticator(@RequestParam String userName, @RequestParam String password, HttpServletRequest request) {

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            subject.login(token);
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return "redirect:/login";
        } catch (AuthenticationException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }

        System.out.println(request.getSession().getAttribute("KAPTCHA_SESSION_KEY").toString());

        return "redirect:/backend";
    }

    @PostMapping("/authentication1")
    public String maAuthenticator(@RequestParam String userName, @RequestParam String password){

        SecurityManager securityManager = new DefaultSecurityManager(new MyRealm1());

        SecurityUtils.setSecurityManager(securityManager);

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return "redirect:/login";
        } catch (AuthenticationException e) {
            System.out.println("what the fuck");
            e.printStackTrace();
        }

        System.out.println(request.getSession().getAttribute("KAPTCHA_SESSION_KEY").toString());

        return "redirect:/backend";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();

        subject.logout();

        return "redirect:/login";
    }

    /**
     * 验证码
     */
    @RequestMapping("/captcha")
    @ResponseBody
    public  void captcha() throws ServletException, IOException {
        KaptchaExtend kaptchaExtend =  new KaptchaExtend();
        kaptchaExtend.captcha(request, response);
    }
}
