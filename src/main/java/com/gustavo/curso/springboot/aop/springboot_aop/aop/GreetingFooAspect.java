package com.gustavo.curso.springboot.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Order(1)
@Component 
@Aspect 
public class GreetingFooAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.gustavo.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes primero: "+ method + " invocando con los parametros " + args);  
    }

    @After("execution(* com.gustavo.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después primero: "+ method + " con los parametros " + args);  
    }
}
