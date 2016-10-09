package com.cvnchina.emsquartz.report.dataaccess;

import java.util.List;
import java.util.Map;

/**
 * Created by Primo on 2016/8/24.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.report.dataaccess
 * COPYRIGHT BY CVNCHINA 2016.
 */
public interface BaseMapper {
    List<Object> queryAll(Map<String,Object> map);

    int queryAllCount(Map map);

    int add(Map<String, Object> map);

    int edit(Map<String, Object> map);

    int del(int id);
}
