package com.example.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zr
 * @date 2023/5/6
 */

@Slf4j(topic = "c.bigStar")
public class bigStar implements star{
    private String name;

    public bigStar() {
    }

    public bigStar(String name) {
        this.name = name;
    }

    @Override
    public String sing(String name){
        log.debug("{}正在唱歌{}",this.name, name);
        return "sing end...";
    }

    @Override
    public String dance(String name){
        log.debug("{}正在跳舞{}",this.name, name);
        return "dance end...";
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "bigStar{name = " + name + "}";
    }
}
