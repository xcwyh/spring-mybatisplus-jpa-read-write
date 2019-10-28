package com.xc.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xc.dao.jpa.PersonRepository;
import com.xc.dao.mybatisplus.AreaMapper;
import com.xc.entity.jpa.Person;
import com.xc.entity.mybatisplus.Area;
import com.xc.param.AreaParam;
import com.xc.param.PersonParam;
import com.xc.service.IAreaService;
import com.xc.service.IPersonService;
import com.xc.util.WrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 管理组 服务类
 * </p>
 *
 * @author xc
 * @since 2019-03-26
 */
@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * 根据请求参数查询列表
     * @param param
     * @return
     */
    @Override
    @DS("slave_1")
    public List<Person> listByParam(PersonParam param){
        return personRepository.findAll();
    }

    /**
     * 根据请求参数查询总数
     * @param param
     * @return
     */
    @Override
    @DS("slave_1")
    public long countByParam(PersonParam param) {
        return personRepository.count();
    }


    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    @DS("slave_1")
    public Person findById(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        return person.isPresent() ? person.get() : null;
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByPersonNameLike("%" + name + "%");
    }

}
