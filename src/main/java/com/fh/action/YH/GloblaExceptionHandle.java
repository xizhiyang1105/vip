package com.fh.action.YH;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class GloblaExceptionHandle {

    //定义要捕捉的异常
    @ExceptionHandler(AjaxException.class)
    //@ResponseBody
    public ServletRequest handException2(AjaxException ex){
        ex.printStackTrace();
        return ServletRequest.error(ex);

    }
    @ExceptionHandler(Exception.class)
   // @ResponseBody
    public ServletRequest handException(Exception ex){
        ex.printStackTrace();
        return ServletRequest.error(ex);

    }


}
