package com.imooc.girl.ecxeption;


import com.imooc.girl.enums.ResultEnum;

/**
 * @Auther: xiaonian
 * @Date: 2018/11/11 16:26
 * @Description:
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
