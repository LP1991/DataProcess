package com.cvnchina.emsquartz.service.business;

import java.util.List;
import java.util.Map;


public interface QueryService {
	public List<Object> queryAll(Map<String,Object> map);

	public int queryAllCount(Map<String, Object> map);
	
	public int add(Map<String, Object> map);
	
	public int edit(Map<String, Object> map);
	
	public int del(int id);
}
