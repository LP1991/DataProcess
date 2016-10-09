package com.cvnchina.emsquartz.service.business;

import com.cvnchina.emsquartz.dataaccess.TableQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Primo on 2016/8/28.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.service.business
 * COPYRIGHT BY CVNCHINA 2016.
 */
@Service
public class TableQueryService {
    @Autowired
    private TableQueryMapper tableQueryMapper;

    public List<Object> queryAll(){
        return tableQueryMapper.queryAll(null);
    }
}
