package com.xc.service;


import com.xc.entity.jpa.Person;
import com.xc.param.PersonParam;

import java.util.List;

/**
 * <p>
 * 管理组 服务类
 * </p>
 *
 * @author xc
 * @since 2019-03-26
 */
public interface IPersonService {

    /**
     * 根据请求参数查询列表
     * @param param
     * @return
     */
    List<Person> listByParam(PersonParam param);

    /**
     * 根据请求参数查询总数
     * @param param
     * @return
     */
    long countByParam(PersonParam param);

    Person add(Person person);

    Person update(Person person);

    void delete(Integer id);

    Person findById(Integer id);

    List<Person> findByName(String name);

}
