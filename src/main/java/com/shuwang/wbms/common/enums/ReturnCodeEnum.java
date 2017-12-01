package com.shuwang.wbms.common.enums;

/**
 * Created by Administrator on 2017/11/30.
 */
public enum ReturnCodeEnum {
    SUCCESS(1, "success"),
    UNKNOWN_ERROR(-1, "server internal error"),
    PARAM_ERROR(-2, "param error"),
    UNMATCHED_METHOD(-3, "unmatched method error"),
    VALID_ERROR(-4, "valid not pass");

    private Integer code;

    private String msg;

    ReturnCodeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
