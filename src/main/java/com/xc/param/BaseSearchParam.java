package com.xc.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseSearchParam implements Serializable {

    @ApiModelProperty(value = "页数，比如'1'")
    protected Integer current = 1;

    @ApiModelProperty(value = "每页条数，比如'20'")
    protected Integer size = 20;

    @ApiModelProperty(value = "创建时间开始，比如'2018-06-07 17:07:40'")
    protected String createStartTime;

    @ApiModelProperty(value = "创建时间截至，比如'2018-06-07 17:07:40'")
    protected String createEndTime;

    @ApiModelProperty(value = "修改时间开始，比如'2018-06-07 17:07:40'")
    protected String updateStartTime;

    @ApiModelProperty(value = "修改时间截至，比如'2018-06-07 17:07:40'")
    protected String updateEndTime;

    @ApiModelProperty(value = "正序或倒叙，比如'desc'")
    protected String orderDirection;

    @ApiModelProperty(value = "排序名称，比如'dealId'")
    protected String orderField;


}
