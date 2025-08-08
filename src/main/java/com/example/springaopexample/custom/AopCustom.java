package com.example.springaopexample.custom;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopCustom {

    @Around("@annotation(Custom)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 부가 기능 수행
        return pjp.proceed();
    }
}
