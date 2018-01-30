package com.shuwang.wbms.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 01-29-2018 10:02
 */

@Aspect
@Component
public class VisitAspect {
    private static final Logger logger = LoggerFactory.getLogger(VisitAspect.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void urlAspect() {

    }

//    @AfterReturning("urlAspect()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Method method = methodSignature.getMethod();

        GetMapping gm = method.getAnnotation(GetMapping.class);

        if (gm != null) {
            logger.info(gm.toString());
        }
    }
}
