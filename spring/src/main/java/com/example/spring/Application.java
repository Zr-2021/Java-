package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.lang.reflect.Field;
import java.util.Locale;
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

        String hi = context.getMessage("hi", null, Locale.CHINESE);
        String hi1 = context.getMessage("hi", null, Locale.ENGLISH);
        String hi2 = context.getMessage("hi", null, Locale.JAPANESE);
        System.out.println(hi + hi1 + hi2);

        Resource[] resources = context.getResources("classpath:application.properties");
        for (Resource resource : resources) {
            System.out.println(resource);
        }

        String java_home = context.getEnvironment().getProperty("JAVA_HOME");
        System.out.println(java_home);

        context.publishEvent(new UserRegisteredEvent(context));
        context.getBean(Register.class).register();
    }
}
