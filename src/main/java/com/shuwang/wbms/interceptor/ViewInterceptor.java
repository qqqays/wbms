package com.shuwang.wbms.interceptor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.shuwang.wbms.common.enums.DisplayEnum;
import com.shuwang.wbms.common.util.MenuPickUtil;
import com.shuwang.wbms.entity.MenuEntity;
import com.shuwang.wbms.service.IMenuService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Q-ays.
 * 12-10-2017 9:09
 */
public class ViewInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IMenuService menuService;

    List<MenuEntity> allTopMenus;
    List<MenuEntity> allSubMenus1;
    List<MenuEntity> topMenus;
    List<MenuEntity> subMenus1;
    List<MenuEntity> footMenus;
    List<MenuEntity> navSliderMenus;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUri = request.getRequestURI();
        String[] aRequest = new String[]{"","",""};
        String[] aRequests = requestUri.split("/");
        for (int i = 0; i < aRequests.length && i < 3; i++){
            aRequest[i] = aRequests[i];
        }
        System.out.println("\nrequestUrl: " + requestUri);
        if(requestUri.startsWith(request.getContextPath())){
            requestUri = requestUri.substring(request.getContextPath().length(), requestUri.length());
        }

        allTopMenus = menuService.selectList(new EntityWrapper<MenuEntity>().eq("deep",0).orderBy("sort"));
        allSubMenus1 = menuService.selectList(new EntityWrapper<MenuEntity>().eq("deep", 1).orderBy("sort"));

        topMenus = MenuPickUtil.topMenus(allTopMenus, aRequest[1]);
        subMenus1 = MenuPickUtil.topSubMenus(allSubMenus1, aRequest[2], aRequest[1]);
        footMenus = MenuPickUtil.pickMenu(allTopMenus, DisplayEnum.FOOT, "deactivate");
        navSliderMenus = MenuPickUtil.pickMenu(allSubMenus1, DisplayEnum.TOP, "deactivate");

        request.setAttribute("topMenus", topMenus);
        request.setAttribute("subMenus1", subMenus1);
        request.setAttribute("footMenus", footMenus);
        request.setAttribute("navSliderMenus", navSliderMenus);

        System.out.println("interceptor");
        return true;
    }
}
