package com.shuwang.wbms.common.controller;

import com.shuwang.wbms.common.enums.ReturnCodeEnum;
import com.shuwang.wbms.common.util.O2JUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Q-ays.
 * 11-29-2017 23:47
 */
public class MyController {

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
}
