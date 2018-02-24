package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.util.MailUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-18-2018 11:10
 */
@RestController
public class MailSendController {

    @GetMapping("/api/sendMail")
    public String sendMail(@RequestParam String name, @RequestParam String phone, @RequestParam String email, @RequestParam String address, @RequestParam String msg, HttpServletRequest request) throws Exception{

        if (!MailUtil.mailSession(request, request.getSession())) {
            return "frequent";
        }

        String content =       "姓名： " + name
                            + ", \n联系电话： " +  phone
                            + ", \n邮箱： " +  email
                            + ", \n地址： " +  address
                            + ", \n留言内容： " + msg;

        try {
//            MailUtil.sendEmail("sales@swpv.net", "网站上的客户留言", content, false);
            MailUtil.sendEmail("whosqays@gmail.com", "网站上的客户留言", content, false);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "success";
    }
}
