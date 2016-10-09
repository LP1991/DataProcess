package com.cvnchina.emsquartz.report.domain;

import org.apache.ibatis.type.Alias;

/**
 * Created by Primo on 2016/8/25.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.report.domain
 * COPYRIGHT BY CVNCHINA 2016.
 */
@Alias("User")
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
