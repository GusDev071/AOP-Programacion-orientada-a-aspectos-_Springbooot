package com.gustavo.curso.springboot.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect 
@Component 
public class GreetingServicePointcuts {

    @Pointcut ("execution(* com.gustavo.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))") // se usa para definir un punto de corte, es decir, un conjunto de métodos a los que se les aplicará el aspecto
    public void greetingLoggerPointCut(){}

    @Pointcut ("execution(* com.gustavo.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))") // se usa para definir un punto de corte, es decir, un conjunto de métodos a los que se les aplicará el aspecto
    public void greetingFooLoggerPointCut(){}

}
