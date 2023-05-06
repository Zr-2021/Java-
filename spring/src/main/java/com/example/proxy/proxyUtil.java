package com.example.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zr
 * @date 2023/5/6
 */
@Slf4j(topic = "c.proxyUtil")
public class proxyUtil {

    public static star creatProxy(bigStar bigStar){
        star star = (star) Proxy.newProxyInstance(
                proxyUtil.class.getClassLoader(),
                new Class[]{com.example.proxy.star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")){
                            log.debug("话筒");
                        }
                        else if (method.getName().equals("dance")){
                            log.debug("舞台");
                        }
                        return method.invoke(bigStar,args);
                    }
                }
        );

        return star;
    }
}
