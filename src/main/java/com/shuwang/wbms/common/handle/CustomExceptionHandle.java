package com.shuwang.wbms.common.handle;

import com.shuwang.wbms.common.enums.ReturnCodeEnum;
import com.shuwang.wbms.common.exception.CustomException;
import com.shuwang.wbms.common.util.O2JUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Catches exceptions of controller
 *
 * Created by Q-ays.
 * 11-30-2017 10:12
 */
@ControllerAdvice
public class CustomExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handle(Exception e) {
        if (e instanceof CustomException) {
            CustomException customException = (CustomException) e;
            return O2JUtil.dataAndCode(customException.getRc(), e.getMessage());
        } else {
            logger.error("[System exception] {}", e);
            return O2JUtil.dataAndCode(ReturnCodeEnum.UNKNOWN_ERROR, e.getMessage());
        }
    }

}
