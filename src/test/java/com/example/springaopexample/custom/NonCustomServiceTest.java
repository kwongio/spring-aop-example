package com.example.springaopexample.custom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NonCustomServiceTest {
    @Autowired
    NonCustomService customService;

    @Test
    void test() {
        System.out.println(customService.getClass().getName());
    }


}