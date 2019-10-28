package com.xc.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.xc.dao.jpa*")
@EntityScan(basePackages = "com.xc.entity.jpa*")
public class JPAConfig {

}
