package com.shuwang.wbms.common.util;

import com.shuwang.wbms.common.enums.ReturnCodeEnum;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Q-ays.
 * 11-30-2017 10:40
 */
public class O2JUtil {

    public static Object isNullData(Object data) {
        if (data == null) return new String("null of data");
        return data;
    }

    public static String list2JsonStr(Collection list) {
        return new JSONArray(list).toString();
    }

    public static String set2JsonStr(Collection set) {
        return list2JsonStr(set);
    }

    public static String map2JsonStr(Map map) {
        return new JSONObject(map).toString();
    }

    public static String dataAndCode(ReturnCodeEnum rc, Object data) {
        return dataAndCode(rc.getCode(), rc.getMsg(), data);
    }

    public static String dataAndCode(Integer code, String msg, Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status-code: ", code);
        jsonObject.put("message: ", msg);
        jsonObject.put("data", isNullData(data));

        return jsonObject.toString();
    }

}
