package com.cvnchina.emsquartz.dataaccess;

import com.cvnchina.emsquartz.domain.Alarmdaily;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Primo on 2016/8/25.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.dataaccess
 * COPYRIGHT BY CVNCHINA 2016.
 */
@Repository
public interface AlarmDailyMapper extends QueryMapper {
    List<Alarmdaily> getAlarmDailyStat(Map<String,Object> map);
}
