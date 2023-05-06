package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        Field objects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        objects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) objects.get(beanFactory);
//        map.forEach((k,v)->{
//            System.out.println(k + " = " + v);
//        });
        map.entrySet().stream().filter(e->e.getKey().contains("bean3")).forEach(e-> System.out.println(e.getKey()+" = "+e.getValue()));
    }
}
