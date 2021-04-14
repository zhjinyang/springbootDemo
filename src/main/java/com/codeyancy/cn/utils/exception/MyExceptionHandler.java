package com.codeyancy.cn.utils.exception;

import com.codeyancy.cn.utils.http.AxiosResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zjy
 * @date 2021/4/13 11:46
 */
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(LoginException.class)
    public AxiosResult<Void> handlerException(LoginException e){

        return AxiosResult.error(e.getEnumStatus());
    }
}
