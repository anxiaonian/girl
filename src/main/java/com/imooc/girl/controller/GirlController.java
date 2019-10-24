package com.imooc.girl.controller;


import com.imooc.girl.domain.Girl;
import com.imooc.girl.domain.Result;
import com.imooc.girl.reprository.GirlRepository;
import com.imooc.girl.service.GirlService;
import com.imooc.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: xiaonian
 * @Date: 2018/11/6 14:38
 * @Description:
 */
@RestController
public class GirlController {

    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    //查询所有
    @GetMapping(value="/girls")
    public List<Girl> girllist(){
       logger.info("girllist");

        return girlRepository.findAll();
    }

    //新增

    /**
     * 添加一个女生
     *
     * @return
     */
    @PostMapping(value="/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //return null;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.getCupSize();
        girl.getAge();
       return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询一个女生byID
     */

    @GetMapping(value="/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id ){
       return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生byID
     */
   @PutMapping(value="/girls/{id}")
    public Girl girlUpdateById (@PathVariable("id") Integer id ,
                                @RequestParam("cupSize") String cupSize,
                                @RequestParam("age") Integer age){
       Girl girl =new Girl();
       girl.setId(id);
       girl.setAge(age);
       girl.setCupSize(cupSize);
       return girlRepository.save(girl);
   }

    /**
     * 删除一个女生byID
     */
    @DeleteMapping(value="/girls/{id}")
    public void girlDeleteById(@PathVariable("id") Integer id ){
         girlRepository.delete(id);
    }
    /**
     * 通过年龄查询
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value ="/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception{
        girlService.getAge(id);
    }
}
