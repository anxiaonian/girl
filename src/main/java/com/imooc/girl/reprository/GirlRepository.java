package com.imooc.girl.reprository;

import com.imooc.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: xiaonian
 * @Date: 2018/11/6 14:43
 * @Description:
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //拓展年龄查询
    public List<Girl> findByAge(Integer age);
}
