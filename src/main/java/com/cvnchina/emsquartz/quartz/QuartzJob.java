package com.cvnchina.emsquartz.quartz;

import com.cvnchina.emsquartz.domain.Alarmdaily;
import com.cvnchina.emsquartz.report.dataaccess.CreateTableMapper;
import com.cvnchina.emsquartz.report.dataaccess.UserMapper;
import com.cvnchina.emsquartz.service.business.AlarmDailyService;
import com.cvnchina.emsquartz.service.business.NeService;
import com.cvnchina.emsquartz.service.business.TableQueryService;
import com.cvnchina.emsquartz.service.business.UserService;
import com.cvnchina.emsquartz.utils.TableTool;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Primo on 2016/8/24.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.quartz
 * COPYRIGHT BY CVNCHINA 2016.
 */
public class QuartzJob {
    @Autowired
    private AlarmDailyService alarmDailyService;
    @Autowired
    private UserService userService;
    @Autowired
    private TableQueryService tableQueryService;
    @Autowired
    private CreateTableMapper createTableMapper;

    public void addUser() {
        try {
            List<Object> list= tableQueryService.queryAll();
            for(Object table : list){
                String code = TableTool.getSuffix(table.toString());
                List<Alarmdaily> alarms =alarmDailyService.getAlarmDailyStat(code);
                for(Alarmdaily alarmdaily : alarms){
                    System.out.println(alarmdaily);
                }
            }
//            createTableMapper.createTmpTable("cityinfo");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
