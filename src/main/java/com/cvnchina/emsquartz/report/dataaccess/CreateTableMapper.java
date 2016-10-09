package com.cvnchina.emsquartz.report.dataaccess;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Primo on 2016/8/28.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.report.dataaccess
 * COPYRIGHT BY CVNCHINA 2016.
 */
@Repository
public interface CreateTableMapper extends BaseMapper{
    void createTmpTable(@Param("tName") String tableName);
}
