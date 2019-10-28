package com.xc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xc.entity.mybatisplus.Area;
import com.xc.param.AreaParam;

import java.util.List;

/**
 * <p>
 * 管理组 服务类
 * </p>
 *
 * @author xc
 * @since 2019-03-26
 */
public interface IAreaService extends IService<Area> {

    /**
     * 根据请求参数查询列表
     * @param param
     * @return
     */
    List<Area> listByParam(AreaParam param);

    /**
     * 根据请求参数查询总数
     * @param param
     * @return
     */
    Integer countByParam(AreaParam param);

    Integer add(Area area);

    Integer update(Area area);

    Integer delete(Integer id);

    Area findById(Integer id);

    Area findByName(String name);

}
