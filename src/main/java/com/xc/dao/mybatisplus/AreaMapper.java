package com.xc.dao.mybatisplus;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xc.entity.mybatisplus.Area;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 管理组 Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-09-24
 */
@Component
public interface AreaMapper extends BaseMapper<Area> {

    @DS("slave_2")
    @Select(value = "select * from area where name like #{name}")
    Area selectByName(@Param("name") String name);
}
