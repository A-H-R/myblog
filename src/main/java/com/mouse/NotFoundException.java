package com.mouse;/*
 *created by mouse on 2020/1/29
 *define not find file
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)   //返回状态
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
