package com.xc.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xc.dao.mybatisplus.AreaMapper;
import com.xc.entity.mybatisplus.Area;
import com.xc.param.AreaParam;
import com.xc.service.IAreaService;
import com.xc.util.WrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理组 服务类
 * </p>
 *
 * @author xc
 * @since 2019-03-26
 */
@Service
public class AreaService extends ServiceImpl<AreaMapper, Area> implements IAreaService {

    @Autowired
    private AreaMapper areaMapper;

    /**
     * 根据请求参数查询列表
     * @param param
     * @return
     */
    @Override
    @DS("slave_1")
    public List<Area> listByParam(AreaParam param){
        QueryWrapper<Area> wrapper = getWrapper(param);
        WrapperUtil.setOrder(wrapper, param, "id");
        Page<Area> page = WrapperUtil.getPage(param);
        if (ObjectUtils.isNotEmpty(page)) {
            return areaMapper.selectPage(page, wrapper).getRecords();
        } else {
            return areaMapper.selectList(wrapper);
        }
    }

    /**
     * 根据请求参数查询总数
     * @param param
     * @return
     */
    @Override
    @DS("slave_1")
    public Integer countByParam(AreaParam param) {
        Wrapper<Area> wrapper = getWrapper(param);
        return areaMapper.selectCount(wrapper);
    }


    @Override
    public Integer add(Area area) {
        return areaMapper.insert(area);
    }

    @Override
    public Integer update(Area area) {
        return areaMapper.updateById(area);
    }

    @Override
    public Integer delete(Integer id) {
        return areaMapper.deleteById(id);
    }

    @Override
    @DS("slave_1")
    public Area findById(Integer id) {
        return areaMapper.selectById(id);
    }

    @Override
    public Area findByName(String name) {
        return areaMapper.selectByName("%" + name + "%");
    }

    /**
     * 自定义查询参数
     * @param param
     * @return
     */
    private QueryWrapper<Area> getWrapper(AreaParam param){
        QueryWrapper<Area> wrapper = new QueryWrapper<Area>();
        if(ObjectUtils.isNotEmpty(param.getId())) {
            wrapper.eq("id", param.getId());
        }
        return wrapper;
    }
}
