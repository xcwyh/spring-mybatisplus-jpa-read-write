package com.xc.param;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AreaParam extends BaseSearchParam {

    private Integer id;
    private String districtId;
    private String name;
    private Integer parentId;
    private Integer level;

}
