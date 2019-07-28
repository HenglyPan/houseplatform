package com.newroad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 */
@ControllerAdvice
public class ErrorHandleController {
   private static final Logger logger=LoggerFactory.getLogger(ErrorHandleController.class);


    @ExceptionHandler(value = {Exception.class,RuntimeException.class})
    public String errro(HttpServletRequest request,Exception e){
        logger.error(e.getMessage(),e);
        logger.error(request.getRequestURI()+"五百啦");
         return "error/400";


    }
}
