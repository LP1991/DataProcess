package com.cvnchina.emsquartz.service.business;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface NeService extends QueryService{

	public int getNeNum();

	List<Object> queryAll(Map<String, Object> map);

}
