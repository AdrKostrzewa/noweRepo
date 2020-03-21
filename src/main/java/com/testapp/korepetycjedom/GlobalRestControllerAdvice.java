package com.testapp.korepetycjedom;

import com.testapp.korepetycjedom.exception.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler({ServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverException(ServerException ex) {
        return ex.getMessage();
    }
}
