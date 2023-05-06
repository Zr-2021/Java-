package com.example.spring;

import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

/**
 * @author zr
 * @date 2023/4/26
 */

public class testEnvironment {
    public static void main(String[] args) throws NoSuchFieldException, IOException {
        System.out.println("==========================>仅获取@Value值");
        QualifierAnnotationAutowireCandidateResolver resolver = new QualifierAnnotationAutowireCandidateResolver();
        Object name = resolver.getSuggestedValue(new DependencyDescriptor(Bean1.class.getDeclaredField("name"), false));
        System.out.println(name);

        System.out.println("==========================>仅获取@Value值,并解析${}");
        Object javaHome = resolver.getSuggestedValue(new DependencyDescriptor(Bean1.class.getDeclaredField("javaHome"), false));
        System.out.println(javaHome);
        System.out.println(getEnvironment().resolvePlaceholders(javaHome.toString()));

        System.out.println("==========================>仅获取@Value值,并解析#{}");
        Object expression = resolver.getSuggestedValue(new DependencyDescriptor(Bean1.class.getDeclaredField("expression"), false));
        System.out.println(expression);
        String exp = getEnvironment().resolvePlaceholders(expression.toString());
        System.out.println(exp);
        System.out.println(new StandardBeanExpressionResolver().evaluate(exp, new BeanExpressionContext(new DefaultListableBeanFactory(), null)));
    }

    private static Environment getEnvironment() throws IOException {
        StandardEnvironment env = new StandardEnvironment();
        env.getPropertySources().addLast(new ResourcePropertySource("jdbc", new ClassPathResource("application.properties")));
        return env;
    }

    static class Bean1{
        @Value("testname")
        private String name;
//        @Value("${all_proxy}")
        @Value("${jdbc.username}")
        private String javaHome;
        @Value("#{'class version:'+'${java.class.version}'}")
        private String expression;
    }
}
