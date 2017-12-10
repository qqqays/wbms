package com.shuwang.wbms.interceptor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shuwang.wbms.entity.MenuEntity;
import com.shuwang.wbms.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Q-ays.
 * 12-10-2017 9:09
 */
public class ViewInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IMenuService menuService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUri = request.getRequestURI();
        System.out.println("requestUrl: " + requestUri);
        if(requestUri.startsWith(request.getContextPath())){
            requestUri = requestUri.substring(request.getContextPath().length(), requestUri.length());
        }

        List<MenuEntity> topMenus = menuService.selectList(new EntityWrapper<MenuEntity>().eq("deep",0).orderBy("sort"));
        List<MenuEntity> subMenus1 = menuService.selectList(new EntityWrapper<MenuEntity>().eq("deep", 1).orderBy("sort"));

        request.setAttribute("topMenus", topMenus);
        request.setAttribute("subMenus1", subMenus1);

        System.out.println("interceptor");
        return true;
    }
}
