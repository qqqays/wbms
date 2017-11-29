package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.controller.MyController;
import com.shuwang.wbms.common.util.UrlMappingUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Q-ays.
 * 11-29-2017 10:21
 */
@RestController("/api/siteMap")
public class SiteMapController extends MyController{

//    @GetMapping()
//    public String siteMap(HttpServletRequest request){
//        return list2JsonStr(UrlMappingUtil.getAllUrlAndMethod(request));
//    }

}
