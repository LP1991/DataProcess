package com.cvnchina.emsquartz.dataaccess;

import org.springframework.stereotype.Repository;
@Repository
public interface OnlineUserMapper extends QueryMapper{
	int getUserNum();
}
