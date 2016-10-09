package com.cvnchina.emsquartz.dataaccess;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cvnchina.emsquartz.domain.Syncalarmstatdata;
@Repository
public interface AlarmStatMapper extends QueryMapper  {
	List<Object> getAlarmlevelNum(int groupid);

	void saveSyncAlarmStat(Syncalarmstatdata sasd);
}
