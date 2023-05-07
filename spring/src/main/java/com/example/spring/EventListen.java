package com.example.spring;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListen {
    @EventListener
    public void monitor(UserRegisteredEvent event){
        System.out.println("监听到:" + event);
        System.out.println("发送短信");
    }
}
