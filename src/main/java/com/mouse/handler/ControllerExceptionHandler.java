package com.mouse.handler;/*
 *created by mouse on 2020/1/29
 *自定义异常拦截
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice   //可以拦截所有有Controller注解的控制器
public class ControllerExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());   //  记录日志
    @ExceptionHandler(Exception.class)     //  该注解标识可以做异常处理,Exception级别的
    //  ModelAndView类可以返回一个页面并携带一些后台返回的参数
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        //记录日志，URL和错误信息
        logger.error("Request URL : {},Exception : {}",request.getRequestURL(),e.getMessage());
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        //返回错误页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("URL",request.getRequestURL());
        mv.addObject("Exception", e);
        mv.setViewName("error/error");  //  第一个error是目录，第二个error是文件名
        return mv;
    }

}
