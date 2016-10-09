package com.cvnchina.emsquartz.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("AlarmlevelNum")
public class AlarmlevelNum implements Serializable {
	private Integer alarmlevelid;
	private Integer num;
	public Integer getAlarmlevelid() {
		return alarmlevelid;
	}
	public void setAlarmlevelid(Integer alarmlevelid) {
		this.alarmlevelid = alarmlevelid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
