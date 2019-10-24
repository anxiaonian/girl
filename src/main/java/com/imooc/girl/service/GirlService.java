package com.imooc.girl.service;

import com.imooc.girl.ecxeption.GirlException;
import com.imooc.girl.enums.ResultEnum;
import com.imooc.girl.reprository.GirlRepository;
import com.imooc.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import sun.plugin2.message.GetAppletMessage;

/**
 * @Auther: xiaonian
 * @Date: 2018/11/6 18:59
 * @Description:
 */
@Service
public class GirlService {

    @Autowired
   private GirlRepository girlRepository;

    @Transactional      //同时
    public  void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(18);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id)throws Exception{
        Girl girl =girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            //返回"你还在上小学吧",code:100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回"你可能上初中" ,code；101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过ID查询一个女生
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
