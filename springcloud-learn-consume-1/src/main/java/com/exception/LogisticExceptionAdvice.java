package com.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class LogisticExceptionAdvice {

    public static final Logger log = Logger.getLogger(LogisticExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(LogisticExcepiton.class)
    public Object handleCustomException(LogisticExcepiton exception) {
        log.info(exception.getMessage());
        Object obj = new Object();
        Integer code = exception.getCode();
//    obj.setCode(code == null?10:code);
//    obj.setInfo(exception.getMessage());
        return obj;
    }
}