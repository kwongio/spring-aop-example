package com.example.springaopexample.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Trasactional {

    @Transactional
    public void test(){}

}

