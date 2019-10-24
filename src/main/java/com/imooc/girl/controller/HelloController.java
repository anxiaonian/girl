package com.imooc.girl.controller;

import com.imooc.girl.properties.Girlproperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    private Girlproperties girlproperties;


    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public  String say(){

        return girlproperties.getCupSize()+girlproperties.getAge();
    }
}
