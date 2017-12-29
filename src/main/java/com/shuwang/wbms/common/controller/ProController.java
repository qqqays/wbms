package com.shuwang.wbms.common.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.shuwang.wbms.common.enums.ReturnCodeEnum;
import com.shuwang.wbms.common.util.O2JUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-20-2017 13:45
 */
public class ProController extends PageController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    public String list2JsonStr(Collection list){
        return O2JUtil.list2JsonStr(list);
    }

    public String set2JsonStr(Collection set){
        return list2JsonStr(set);
    }

    public String map2JsonStr(Map map) {
        return O2JUtil.map2JsonStr(map);
    }

    public String dataAndCode(ReturnCodeEnum code, Object data){
        return O2JUtil.dataAndCode(code, data);
    }

    public String page2JsonStr(Page datagram){
        return new JSONObject(datagram).toString();
    }

    public String O2JsonStr(Object o) {
        return new JSONObject(o).toString();
    }

    public void chooseContent() {

    }
}
