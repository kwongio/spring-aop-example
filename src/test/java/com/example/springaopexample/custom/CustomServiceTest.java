package com.example.springaopexample.custom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomServiceTest {

    @Autowired
    CustomService customService;
    @Test
     void test() {
        System.out.println(customService.getClass().getName());
//        Assertions.assertThat(AopUtils.isAopProxy(customService)).isTrue();
    }

}