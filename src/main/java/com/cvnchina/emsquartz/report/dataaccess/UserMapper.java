package com.cvnchina.emsquartz.report.dataaccess;

import com.cvnchina.emsquartz.report.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Primo on 2016/8/24.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.report.dataaccess
 * COPYRIGHT BY CVNCHINA 2016.
 */
@Repository
public interface UserMapper extends BaseMapper{
    int addUser(User user);
    int getUserNum();
}
