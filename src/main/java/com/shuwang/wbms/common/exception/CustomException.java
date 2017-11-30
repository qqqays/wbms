package com.shuwang.wbms.common.exception;

import com.shuwang.wbms.common.enums.ReturnCodeEnum;

/**
 * Created by Q-ays.
 * 11-30-2017 10:06
 */
public class CustomException extends RuntimeException{

    private ReturnCodeEnum rc;

    public CustomException(ReturnCodeEnum rc) {
        super();
        this.rc = rc;
    }

    public ReturnCodeEnum getRc() {
        return rc;
    }

    public void setRc(ReturnCodeEnum rc) {
        this.rc = rc;
    }
}
