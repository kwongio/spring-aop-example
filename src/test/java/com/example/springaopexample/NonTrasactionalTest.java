package com.example.springaopexample;

import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NonTrasactionalTest {

    @Autowired
    private NonTrasactional nonTrasactional;

    @Autowired
    private Trasactional trasactional;

    @Autowired
    private AsyncService async;

    @Test
    void nonTrasactionalTest() {
        System.out.println(nonTrasactional);
        System.out.println(trasactional);
    }

    @Test
    void nonTrasactionalTest2() {
        System.out.println("NonTrasactional instanceof Proxy? " + AopUtils.isAopProxy(nonTrasactional));
        System.out.println("Trasactional instanceof Proxy? " + AopUtils.isAopProxy(trasactional));
        System.out.println("async instanceof Proxy? " + AopUtils.isAopProxy(async));

        System.out.println(nonTrasactional.getClass().getName());
        System.out.println(trasactional.getClass().getName());
        System.out.println(async.getClass().getName());
    }
}