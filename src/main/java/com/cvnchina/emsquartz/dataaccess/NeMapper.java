package com.cvnchina.emsquartz.dataaccess;

import org.springframework.stereotype.Repository;
@Repository
public interface NeMapper extends QueryMapper {
	int getNeNum();
}
