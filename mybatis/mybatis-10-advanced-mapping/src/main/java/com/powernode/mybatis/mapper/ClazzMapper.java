package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Clazz;

public interface ClazzMapper {

    Clazz selectByIdStep2(Integer id);

    Clazz selectByCollection(Integer id);

    Clazz selectByCidStep1(Integer id);

}
