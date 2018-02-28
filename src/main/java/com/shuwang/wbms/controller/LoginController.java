package com.shuwang.wbms.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.servlet.KaptchaExtend;
import com.shuwang.wbms.common.anno.UserLog;
import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.entity.UserEntity;
import com.shuwang.wbms.service.ILogService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-28-2017 13:21
 */
@Controller
public class LoginController extends ProController{

    private Producer captchaProducer = null;

    @Autowired
    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    @Autowired
    private ILogService logService;

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @UserLog("Login")
    @PostMapping("/authentication")
    public String authenticator(@RequestParam String userName, @RequestParam String password, @RequestParam String captcha, HttpServletRequest request) {

        if (request.getSession().getAttribute("KAPTCHA_SESSION_KEY") == null) {
            return "redirect:/login";
        }

        if (!request.getSession().getAttribute("KAPTCHA_SESSION_KEY").equals(captcha)) {
            return "redirect:/login";
        }

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            subject.login(token);
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            e.printStackTrace();
            return "redirect:/login";
        } catch (AuthenticationException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }

        UserEntity userEntity = (UserEntity) subject.getPrincipal();

        request.getSession().setAttribute("userInfo", userEntity);

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
//        KaptchaExtend kaptchaExtend =  new KaptchaExtend();
//        request.setCharacterEncoding("UTF-8");
//        kaptchaExtend.captcha(request, response);
//        System.out.println(request.getSession().getAttribute("KAPTCHA_SESSION_KEY"));

        response.setDateHeader("Expires", 0);// 禁止server端缓存
        // 设置标准的 HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // 设置IE扩展 HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");// 设置标准 HTTP/1.0 不缓存图片
        response.setContentType("image/jpeg");// 返回一个 jpeg 图片，默认是text/html(输出文档的MIMI类型)
        String capText = captchaProducer.createText();// 为图片创建文本

        // 将文本保存在session中。这里就使用包中的静态变量吧
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        BufferedImage bi = captchaProducer.createImage(capText); // 创建带有文本的图片
        ServletOutputStream out = response.getOutputStream();
        // 图片数据输出
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }

//        System.out.println("Session 验证码是：" + request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
    }
}
