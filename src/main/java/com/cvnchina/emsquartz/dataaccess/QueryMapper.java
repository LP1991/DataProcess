package com.cvnchina.emsquartz.dataaccess;

import java.util.List;
import java.util.Map;

public interface QueryMapper {
	List<Object> queryAll(Map<String,Object> map);

	int queryAllCount(Map<String, Object> map);

	int add(Map<String, Object> map);

	int edit(Map<String, Object> map);

	int del(int id);
}
