package com.cvnchina.emsquartz.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
@Alias("Rgroup")
public class Rgroup implements Serializable {
	private Integer groupid;
	private String groupname;
	public Integer getGroupid() {
		return groupid;
	}
	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
}
