package com.xc.param;

import lombok.Data;

@Data
public class PersonParam extends BaseSearchParam {

    private Integer id;
    private String personName;
    private Integer personAge;
    private String personDesc;

}
