package com.gustavo.curso.springboot.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.annotation.Order;

@Order(2)
@Aspect
@Component 
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut ("execution(* com.gustavo.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))") // se usa para definir un punto de corte, es decir, un conjunto de métodos a los que se les aplicará el aspecto
    private void greetingLoggerPointCut(){}
    @Before("greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: "+ method + " con los argumentos " + args);  
    }

    @After("greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después: "+ method + " con los argumentos " + args);  
    }

    @AfterReturning("greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después (retorno): "+ method + " con los argumentos " + args);  
    }
    
    @AfterThrowing("greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint){
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después (excepción): "+ method + " con los argumentos " + args);  
    }

    @Around ("greetingLoggerPointCut()") // Se ejecuta antes y después del método
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;

        try{
            logger.info("El metodo: "+ method + " con los parametros " + args);
            result = joinPoint.proceed(); // Ejecuta el método original
            logger.info("El metodo: "+ method  + " retornó los resultados: " + result);
            return result;
        }catch (Throwable e) {
            logger.error("El error en la llamada al método: "+ method  + "()");
            throw e;
        }
    }
}
