package com.shuwang.wbms.common.aspect;

import com.shuwang.wbms.common.anno.UserLog;
import com.shuwang.wbms.entity.UserEntity;
import com.shuwang.wbms.service.ILogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-29-2018 10:02
 */

@Aspect
@Component
public class VisitAspect {

    @Autowired
    private ILogService logService;

    private static final Logger logger = LoggerFactory.getLogger(VisitAspect.class);


    @Pointcut("@annotation(com.shuwang.wbms.common.anno.UserLog)")
    public void userLog(){

    }

    @AfterReturning("userLog()")
    public void after4user(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        UserLog ul = method.getAnnotation(UserLog.class);

        try {
            logService.simpleLogInsert(
                    ((UserEntity) SecurityUtils.getSubject().getPrincipal()).getUserName(),
                    request.getRemoteAddr(),
                    ul.value());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
