package com.shuwang.wbms.common.util;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.*;
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


    /**
     *  enum set transform string set
     * @return
     */
    public static Set<String> eSet2strSet(Set eSet){

        Set<String> sSet = new HashSet<>();

        if (eSet.size() == 0) {
            return sSet.add("Accept all methods") ? sSet : null;
        }

        Iterator it = eSet.iterator();

        if (it.hasNext()){
            sSet.add(it.next().toString());
        }

        return sSet;
    }

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
            HandlerMethod hm = handlerMethods.get(rmi);

            Map<String, Map> map = new ConcurrentHashMap<>();

            Map<String, Object>  subMap = new ConcurrentHashMap<>();

            subMap.put("api", pc.getPatterns());
            subMap.put("request_methods", eSet2strSet(rm.getMethods()));
            subMap.put("backend_methods", hm.toString());
//            subMap.put("declare_annotations", hm.getMethod().getDeclaredAnnotations());

            map.put(hm.getMethod().getName(), subMap);

            list.add(map);
        }

        return list;
    }

}
