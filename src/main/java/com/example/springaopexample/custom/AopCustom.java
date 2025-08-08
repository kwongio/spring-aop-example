package com.example.springaopexample.custom;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopCustom {

    @Around("@annotation(Custom)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 부가 기능 수행
        return pjp.proceed();
    }

    @Around("within(com.example..*)")
    public Object around2(ProceedingJoinPoint pjp) throws Throwable {
        // com.example.service 패키지와 하위 모든 클래스 대상
        log.info("around2");
        return pjp.proceed();
    }
}
