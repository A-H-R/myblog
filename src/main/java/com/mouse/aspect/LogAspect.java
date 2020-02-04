package com.mouse.aspect;
/*
 *created by mouse on 2020/2/4
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.mouse.web.*.*(..))")    //  标识起切面作用,execution()里面标识拦截哪些的类
    /*
      例如 web下的所有控制 第一个* ： 任何的方法（public、private。。。）之后是  具体的包名+类名+方法+参数
    */
    public void log() {}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //  获取HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String URL = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(URL, ip, classMethod, args);
        logger.info("Request : {}",requestLog);
    }

    @After("log()")
    public void doAfter() {
//        logger.info("--------doafter-----------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")       // 参数返回的东西
    //  拦截返回的结果
    public void doAfterRuturn(Object result) {
        logger.info("Result : {}",result);
    }

    //  内部类
    private class RequestLog {
        private String URL;
        private String ip;
        private String classMethod;
        private Object args;

        public RequestLog(String URL, String ip, String classMethod, Object args) {
            this.URL = URL;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "URL='" + URL + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + args +
                    '}';
        }
    }


}

