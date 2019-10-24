package com.imooc.girl.handle;
import com.imooc.girl.ecxeption.GirlException;
import com.imooc.girl.utils.ResultUtil;
import com.imooc.girl.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: xiaonian
 * @Date: 2018/11/11 16:13
 * @Description:
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(Exception.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("[系统异常]{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
