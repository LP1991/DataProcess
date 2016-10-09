package com.cvnchina.emsquartz.service.business;

import com.cvnchina.emsquartz.dataaccess.AlarmDailyMapper;
import com.cvnchina.emsquartz.domain.Alarmdaily;
import com.cvnchina.emsquartz.utils.TableTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Primo on 2016/8/25.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.service.business
 * COPYRIGHT BY CVNCHINA 2016.
 */
@Service
public class AlarmDailyService {
    @Autowired
    private AlarmDailyMapper alarmDailyMapper;

    public List<Alarmdaily> getAlarmDailyStat(String code){
        Map<String,Object> map = new HashMap<String, Object>();
        java.util.Date date=new java.util.Date();//取时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
//        calendar.add(calendar.DATE,-21);
        date=calendar.getTime();
        String begin = formatter.format(date);

        calendar.add(calendar.DATE,1);
        date=calendar.getTime();
        String end = formatter.format(date);
        map.put("table", TableTool.currentalarm+code);
        map.put("begindate",begin);
        map.put("begindate",end);
        System.out.print(begin+" "+end);
        return alarmDailyMapper.getAlarmDailyStat(map);
    }
}
