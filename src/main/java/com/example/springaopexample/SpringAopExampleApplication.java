package com.example.springaopexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringAopExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopExampleApplication.class, args);
    }
}
