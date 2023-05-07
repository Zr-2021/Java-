package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Register {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void register(){
        System.out.println("注册成功");
        publisher.publishEvent(new UserRegisteredEvent(this));
    }
}
