package com.cvnchina.emsquartz.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
@Alias("HebeiNeNum")
public class HebeiNeNum implements Serializable {
	private Integer id;
	private Integer nealarmnum;
	private Integer nenum;
	private Timestamp cratetime;
	private String companyinfo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNealarmnum() {
		return nealarmnum;
	}
	public void setNealarmnum(Integer nealarmnum) {
		this.nealarmnum = nealarmnum;
	}
	public Integer getNenum() {
		return nenum;
	}
	public void setNenum(Integer nenum) {
		this.nenum = nenum;
	}
	public Timestamp getCratetime() {
		return cratetime;
	}
	public void setCratetime(Timestamp cratetime) {
		this.cratetime = cratetime;
	}
	public String getCompanyinfo() {
		return companyinfo;
	}
	public void setCompanyinfo(String companyinfo) {
		this.companyinfo = companyinfo;
	}
	
}
