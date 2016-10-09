package com.cvnchina.emsquartz.dataaccess;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface RgroupMapper extends QueryMapper {
	List<Object> getFirstGroups();
	void addGroupAlarm(Map<String,Object> map);
}
