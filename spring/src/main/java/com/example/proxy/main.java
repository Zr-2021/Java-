package com.example.proxy;

/**
 * @author zr
 * @date 2023/5/6
 */

public class main {
    public static void main(String[] args, bigStar bigStar) {
        star proxy = proxyUtil.creatProxy(new bigStar("坤坤"));
        proxy.dance("鸡你太美");
    }
}
