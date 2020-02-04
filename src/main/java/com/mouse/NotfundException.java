package com.mouse;/*
 *created by mouse on 2020/1/29
 *define not find file
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)   //返回状态
public class NotfundException extends RuntimeException{

    public NotfundException() {
    }

    public NotfundException(String message) {
        super(message);
    }

    public NotfundException(String message, Throwable cause) {
        super(message, cause);
    }
}
