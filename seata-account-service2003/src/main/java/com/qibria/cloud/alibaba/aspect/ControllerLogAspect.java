package com.qibria.cloud.alibaba.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class ControllerLogAspect {

    private final Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);

    // 定义切入点
    @Pointcut("execution(* com.qibria.cloud.alibaba.controller.*.*(..))")
    public void logPointCut(){}

    //  前置通知 获取Request参数
    @Around("logPointCut()")
    public Object record(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("start request -->");
        logger.info("请求地址:"+ request.getRequestURI());
        logger.info("HTTP METHOD:"+request.getMethod());
        logger.info("类方法 class_method:"+joinPoint.getSignature().getDeclaringTypeName()+"-"+joinPoint.getSignature().getName()+"()");
        logger.info("请求参数 args:"+ Arrays.toString(joinPoint.getArgs()));
        logger.info("返回值类型: {}",((MethodSignature)joinPoint.getSignature()).getMethod().getReturnType().getName());
        Object proceed = joinPoint.proceed();
        logger.info("<-- end request");
        return proceed;
    }
}
