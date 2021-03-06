package com.shuwang.wbms.common.aspect;

import com.shuwang.wbms.entity.UserEntity;
import com.shuwang.wbms.service.ILogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Q-ays.
 * 11-29-2017 9:06
 */
@Aspect
@Component
public class ApiAspect {

    @Autowired
    private ILogService logService;

    private static final Logger logger = LoggerFactory.getLogger(ApiAspect.class);

    @Pointcut("execution(public * com.shuwang.wbms.controller.api.*.*(..))")
    public void apiLog() {
    }


    @Before("apiLog()")
    public void doBefore4api(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("\nurl={}", request.getRequestURL());

        //method
        logger.info("request_method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

//        api
        logger.info("api={}", request.getRequestURI());

        //类方法
//        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("class_method={}", joinPoint.getSignature());

        if (!request.getMethod().toUpperCase().equals(RequestMethod.GET.toString())) {
            try {
                logService.apiLogInsert(
                        ((UserEntity) SecurityUtils.getSubject().getPrincipal()).getUserName(),
                        request.getRemoteAddr(),
                        request.getRequestURI(),
                        request.getMethod(),
                        joinPoint.getSignature().toString(),
                        "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
