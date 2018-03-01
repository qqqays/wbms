package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.common.enums.ReturnCodeEnum;
import com.shuwang.wbms.common.exception.CustomException;
import com.shuwang.wbms.common.util.UrlMappingUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Q-ays.
 * 11-29-2017 10:21
 */
@RestController
@RequestMapping("/api/siteMap")
public class SiteMapController extends ProController{

    @GetMapping()
    public String siteMap(HttpServletRequest request){
        return list2JsonStr(UrlMappingUtil.getAllUrlAndMethod(request));
    }

    @GetMapping("/exception")
    public void  exception() throws Exception{
        throw new CustomException(ReturnCodeEnum.SUCCESS);
    }

}
