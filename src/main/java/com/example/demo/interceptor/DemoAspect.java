package com.example.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义一个AOP拦截器切面，并且使用注解方式进行拦截触发
 *
 * @author alexzhang
 */
@Aspect
@Component
@Slf4j
public class DemoAspect {


    /**
     * 定义一个切点 使用注解进行切面的拦截
     * 即 有这个注解的方法才会进行拦截
     */
    @Pointcut("@annotation(com.example.demo.interceptor.interceptorAnnotation)")
    private void interceptorAnnotation() {
    }

    /*
     * Advice是定义在切面里面的处理逻辑
     * Advice的类型在AdviceKind.java中定义的 默认是五种类型
     * 1、@Before
     * 2、@Around
     * 3、@After
     * 4、@AfterReturning
     * 5、@AfterThrowing
     */


    @Before("interceptorAnnotation()")
    public void beforeDemo(JoinPoint joinPoint) {
        log.info("进来@Before了！");
    }


    @Around("interceptorAnnotation()")
    public Object aroundDemo(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("coming into this annotation!");
        return new Object();
    }

}
