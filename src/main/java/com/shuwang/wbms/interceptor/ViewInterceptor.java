package com.shuwang.wbms.interceptor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUri = request.getRequestURI();
        String[] aRequest = new String[]{"","",""};
        String[] aRequests = requestUri.split("/");
        for (int i = 0; i < aRequests.length; i++){
            aRequest[i] = aRequests[i];
        }
        System.out.println("\nrequestUrl: " + requestUri);
        if(requestUri.startsWith(request.getContextPath())){
            requestUri = requestUri.substring(request.getContextPath().length(), requestUri.length());
        }

        allTopMenus = menuService.selectList(new EntityWrapper<MenuEntity>().eq("deep",0).orderBy("sort"));
        allSubMenus1 = menuService.selectList(new EntityWrapper<MenuEntity>().eq("deep", 1).orderBy("sort"));
        topMenus = new ArrayList<MenuEntity>();
        subMenus1 = new ArrayList<MenuEntity>();

        Iterator<MenuEntity> allTopIt = allTopMenus.iterator();
        Iterator<MenuEntity> allSubIt1 = allSubMenus1.iterator();

        while (allTopIt.hasNext()){

            MenuEntity topMenu = allTopIt.next();

            if((topMenu.getDisplay() & 1) == 1){ //判断是否显示

                String topId = topMenu.getId(); //取当前顶部菜单id

                if(topId.equals(aRequest[1])){ //当前顶部菜单id等于url，设置为true

                    topMenu.setActive(true);

                    while (allSubIt1.hasNext()) { //根据活动的顶部菜单取子菜单
                        MenuEntity subMenu1 = allSubIt1.next();
                        if(topId.equals(subMenu1.getPid())){
                            try {
                                if (subMenu1.getId().equals(aRequest[2])) {
                                    subMenu1.setActive(true);
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("not find");
                            }

                            subMenus1.add(subMenu1);
                        }
                    }

                }
                topMenus.add(topMenu);
            }
        }

        request.setAttribute("topMenus", topMenus);
        request.setAttribute("subMenus1", subMenus1);

        System.out.println("interceptor");
        return true;
    }
}
