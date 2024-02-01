package com.newsfeedservice.global.exception;

import com.newsfeedservice.global.dto.WebResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public WebResponseData<Object> userExceptionHandler(UserException userException){
        return WebResponseData.error(userException.getErrorCode());
    }
}
