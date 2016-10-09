package com.cvnchina.emsquartz.dataaccess;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cvnchina.emsquartz.domain.HebeiNeNum;
@Repository
public interface DeviceStatMapper extends QueryMapper {
	int getDeviceNum(Map<String,Object> map);

	void addDeviceNum(HebeiNeNum hebeiNeNum);
}
