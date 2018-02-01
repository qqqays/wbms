package com.shuwang.wbms.common.exception;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 02-01-2018 9:17
 */
public class MatchSystemException extends RuntimeException{

    public MatchSystemException() {
        super("Can not match the system initialed");
    }
}
