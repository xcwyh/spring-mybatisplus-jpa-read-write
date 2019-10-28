package com.xc.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xc.param.BaseSearchParam;

/**
 * Created by devil on 2018/8/23.
 */
public class WrapperUtil {

    public static void setOrder(QueryWrapper queryWrapper, BaseSearchParam param, String primaryKey){
        if (null == param) {
            throw new RuntimeException("设置排序时无可用参数!");
        } else {
            if (ObjectUtils.isNotEmpty(param.getOrderDirection()) && ObjectUtils.isNotEmpty(param.getOrderField())) {
                if(ObjectUtils.isNotEmpty(param.getOrderField()) && "asc".equals(param.getOrderDirection())){
                    queryWrapper.orderByAsc(param.getOrderField());
                }else{
                    queryWrapper.orderByDesc(param.getOrderField());
                }
            } else {
                if (ObjectUtils.isNotEmpty(primaryKey)) {
                    queryWrapper.orderByDesc(primaryKey);
                } else {
                    throw new RuntimeException("设置排序时, 排序字段缺失并未明确主键字段!");
                }

            }
        }
    }

    public static Page getPage(BaseSearchParam param){
        if (ObjectUtils.isNotEmpty(param) && (ObjectUtils.isNotEmpty(param.getCurrent()) || ObjectUtils.isNotEmpty(param.getSize()))) {
            //分页
            Page page = new Page();
            if(ObjectUtils.isNotEmpty(param.getCurrent())) {
                page.setCurrent(param.getCurrent());
            }
            if(ObjectUtils.isNotEmpty(param.getSize())) {
                page.setSize(param.getSize());
            }
            return page;
        }else{
            return null;
        }
    }


}
