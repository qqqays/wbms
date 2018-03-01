package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.enums.ReturnCodeEnum;
import com.shuwang.wbms.common.exception.CustomException;
import com.shuwang.wbms.entity.UserEntity;
import com.shuwang.wbms.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 03-01-2018 16:22
 */
@Controller
@RequestMapping("/api/profile")
public class ProfileController {

    @PutMapping("/me")
    public String me(UserEntity userEntity) {

        UserEntity userEntity1 = getUserInSession();

        userEntity.setPassword(userEntity1.getPassword());

        return userEntity.updateById() + " update";
    }

    @PutMapping("/password")
    public String password(String originPwd, String newPwd) {

        UserEntity userEntity = getUserInSession();

        if (userEntity.getPassword().equals(originPwd))
            userEntity.setPassword(newPwd);
        else
            throw new CustomException(ReturnCodeEnum.PASSWORD_ERROR);

        return userEntity.updateById() + " update";
    }

    private UserEntity getUserInSession() {

        Subject subject = SecurityUtils.getSubject();

        UserEntity userEntity = (UserEntity) subject.getPrincipal();

        if (userEntity == null) {
            throw new CustomException(ReturnCodeEnum.PRINCIPAL_NOT_FIND);
        }

        return userEntity.selectById();
    }
}
