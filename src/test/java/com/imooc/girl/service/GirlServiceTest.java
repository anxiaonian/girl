package com.imooc.girl.service;

import com.imooc.girl.GirlApplication;
import com.imooc.girl.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: xiaonian
 * @Date: 2018/11/12 18:38
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GirlApplication.class)
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl =girlService.findOne(3);
        Assert.assertEquals(new Integer(15), girl.getAge());
    }
}
