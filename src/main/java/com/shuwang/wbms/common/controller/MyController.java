package com.shuwang.wbms.common.controller;

import com.shuwang.wbms.common.enums.ReturnCode;
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
        return new JSONArray(list).toString();
    }

    public String set2JsonStr(Collection set){
        return list2JsonStr(set);
    }

    public String map2JsonStr(Map map) {
        return new JSONObject(map).toString();
    }

    public String dataAndCode(ReturnCode code, Object data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status-code: ", code.getCode());
        jsonObject.put("message: ", code.getMsg());
        jsonObject.put("data", data);

        return jsonObject.toString();
    }
}
