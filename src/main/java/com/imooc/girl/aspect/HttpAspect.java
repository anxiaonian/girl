package com.imooc.girl.aspect;

import com.imooc.girl.domain.Girl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

/**
 * @Auther: xiaonian
 * @Date: 2018/11/7 18:46
 * @Description:
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    //制定切点
    @Pointcut("execution(public * com.imooc.girl.controller.GirlController.*(..))")
    public void log(){
    }
    //前置通知
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class-method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数 args
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("2222222222");

    }
    @AfterReturning(pointcut = "log()",returning = "object")
    public void doAfterReturning(Object object)
    {
        logger.info("response={}",object.toString());
    }
}
