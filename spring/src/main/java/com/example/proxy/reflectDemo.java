package com.example.proxy;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author zr
 * @date 2023/5/6
 */

public class reflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException, InstantiationException {
        Class clazz = Class.forName("com.example.proxy.bigStar");

        //所有的public构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        bigStar bigStar = new bigStar("坤坤");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        Object o = name.get(bigStar);
        System.out.println(o);

        Method sing = clazz.getDeclaredMethod("sing", String.class);
        sing.setAccessible(true);
        Object str = sing.invoke(bigStar, "鸡你太美");
        System.out.println(str);

        Properties prop = new Properties();
        FileInputStream propFiles = new FileInputStream("spring/src/main/resources/prop.properties");
        prop.load(propFiles);

        String className = prop.getProperty("className");
        String method = prop.getProperty("method");

        Class cla = Class.forName(className);
        Constructor con = cla.getDeclaredConstructor();
        Object instance = con.newInstance();

        Method method1 = cla.getDeclaredMethod(method, String.class);
        method1.setAccessible(true);
        method1.invoke(instance,"鸡你太美");
    }
}
