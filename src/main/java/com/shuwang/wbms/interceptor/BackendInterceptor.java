package com.shuwang.wbms.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-14-2017 13:59
 */
public class BackendInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("\nbackend interceptor :" + request.getRequestURI());

        return true;
    }

}
