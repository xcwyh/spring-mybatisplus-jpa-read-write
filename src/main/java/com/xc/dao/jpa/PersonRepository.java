package com.xc.dao.jpa;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xc.entity.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {

    @DS("slave_2")
    List<Person> findByPersonNameLike(String name);

}
