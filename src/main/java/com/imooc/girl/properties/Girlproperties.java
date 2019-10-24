package com.imooc.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: xiaonian
 * @Date: 2018/11/4 21:45
 * @Description:
 */
@Component
//@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "girl")
public class Girlproperties {
    private String cupSize;

    private  Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

