package com.shuwang.wbms.common.util;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Q-ays.
 * 11-29-2017 10:19
 */
public class UrlMappingUtil {
    public static Set<String> getAllUrl(HttpServletRequest request) {
        Set<String> result = new HashSet<>();
        WebApplicationContext wc = (WebApplicationContext) request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        RequestMappingHandlerMapping bean = wc.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = bean.getHandlerMethods();
        for (RequestMappingInfo rmi : handlerMethods.keySet()) {
            PatternsRequestCondition pc = rmi.getPatternsCondition();
            Set<String> pSet = pc.getPatterns();
            result.addAll(pSet);
        }
        return result;
    }

    public static List<Map> getAllUrlAndMethod(HttpServletRequest request){
        List<Map> list = new ArrayList<>();

        WebApplicationContext wc = (WebApplicationContext) request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);

        RequestMappingHandlerMapping bean = wc.getBean(RequestMappingHandlerMapping.class);

        Map<RequestMappingInfo, HandlerMethod> handlerMethods = bean.getHandlerMethods();

        for (RequestMappingInfo rmi : handlerMethods.keySet()) {
            PatternsRequestCondition pc = rmi.getPatternsCondition();
            RequestMethodsRequestCondition rm = rmi.getMethodsCondition();

            Iterator it = rm.getMethods().iterator();

            Set<String> rmSet = new HashSet<>();

            Map<String, List> map = new ConcurrentHashMap<>();

            List<Set> setList = new ArrayList<>();

            while (it.hasNext()) {
                rmSet.add(it.next().toString());
//                map.put(UUID.randomUUID().toString(), rmSet);
            }

            setList.add(rmSet);
            setList.add(pc.getPatterns());

            map.put(UUID.randomUUID().toString(), setList);

            list.add(map);
        }

        return list;
    }

}
