package com.cvnchina.emsquartz.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
@Alias("Syncalarmstatdata")
public class Syncalarmstatdata implements Serializable {
	private Integer id;
	private String areacode;
	private Integer oltalarmlevel1;
	private Integer alarmlevel1;
	private Integer alarmlevel2;
	private Integer alarmlevel3;
	private Integer alarmlevel4;
	private Integer alarmlevel5;
	private Integer alarmlevel6;
	private Integer alarmlevel7;
	private Timestamp stattime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public Integer getOltalarmlevel1() {
		return oltalarmlevel1;
	}
	public void setOltalarmlevel1(Integer oltalarmlevel1) {
		this.oltalarmlevel1 = oltalarmlevel1;
	}
	public Integer getAlarmlevel1() {
		return alarmlevel1;
	}
	public void setAlarmlevel1(Integer alarmlevel1) {
		this.alarmlevel1 = alarmlevel1;
	}
	public Integer getAlarmlevel2() {
		return alarmlevel2;
	}
	public void setAlarmlevel2(Integer alarmlevel2) {
		this.alarmlevel2 = alarmlevel2;
	}
	public Integer getAlarmlevel3() {
		return alarmlevel3;
	}
	public void setAlarmlevel3(Integer alarmlevel3) {
		this.alarmlevel3 = alarmlevel3;
	}
	public Integer getAlarmlevel4() {
		return alarmlevel4;
	}
	public void setAlarmlevel4(Integer alarmlevel4) {
		this.alarmlevel4 = alarmlevel4;
	}
	public Integer getAlarmlevel5() {
		return alarmlevel5;
	}
	public void setAlarmlevel5(Integer alarmlevel5) {
		this.alarmlevel5 = alarmlevel5;
	}
	public Integer getAlarmlevel6() {
		return alarmlevel6;
	}
	public void setAlarmlevel6(Integer alarmlevel6) {
		this.alarmlevel6 = alarmlevel6;
	}
	public Integer getAlarmlevel7() {
		return alarmlevel7;
	}
	public void setAlarmlevel7(Integer alarmlevel7) {
		this.alarmlevel7 = alarmlevel7;
	}
	public Timestamp getStattime() {
		return stattime;
	}
	public void setStattime(Timestamp stattime) {
		this.stattime = stattime;
	}
	
}
