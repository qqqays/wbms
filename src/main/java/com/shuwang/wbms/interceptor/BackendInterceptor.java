package com.shuwang.wbms.interceptor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.shuwang.wbms.entity.BackendMenuEntity;
import com.shuwang.wbms.service.IBackendMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-14-2017 13:59
 */
public class BackendInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    private IBackendMenuService backendMenuService;

    Wrapper<BackendMenuEntity> topWrapper = new EntityWrapper<BackendMenuEntity>().eq("deep", 0).orderBy("sort");
    Wrapper<BackendMenuEntity> subWrapper = new EntityWrapper<BackendMenuEntity>().eq("deep",1).orderBy("sort");
    List<BackendMenuEntity> backendTopMenus;
    List<BackendMenuEntity> backendSubMenus;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        backendTopMenus = backendMenuService.selectList(topWrapper);
        backendSubMenus = backendMenuService.selectList(subWrapper);

        request.setAttribute("backendTopMenus", backendTopMenus);
        request.setAttribute("backendSubMenus", backendSubMenus);

        System.out.println("\nbackend interceptor :" + request.getRequestURI());
        return true;
    }

}
