package com.cvnchina.emsquartz.domain;

import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * Created by Primo on 2016/8/25.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.domain
 * COPYRIGHT BY CVNCHINA 2016.
 */
@Alias("Alarmdaily")
public class Alarmdaily {
    private Integer id;
    private int groupid;
    private int alarmlevel;
    private int alarmcatelogid;
    private int alarmnum;
    private Timestamp alarmdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGroupname() {
        return groupid;
    }

    public void setGroupname(int groupname) {
        this.groupid = groupname;
    }

    public int getAlarmlevel() {
        return alarmlevel;
    }

    public void setAlarmlevel(int alarmlevel) {
        this.alarmlevel = alarmlevel;
    }

    public int getAlarmcatelogid() {
        return alarmcatelogid;
    }

    public void setAlarmcatelogid(int alarmcatelogid) {
        this.alarmcatelogid = alarmcatelogid;
    }

    public int getAlarmnum() {
        return alarmnum;
    }

    public void setAlarmnum(int alarmnum) {
        this.alarmnum = alarmnum;
    }

    public Timestamp getAlarmdate() {
        return alarmdate;
    }

    public void setAlarmdate(Timestamp alarmdate) {
        this.alarmdate = alarmdate;
    }

    @Override
    public String toString() {
        return "Alarmdaily{" +
                "groupname='" + groupid + '\'' +
                ", alarmlevel=" + alarmlevel +
                ", alarmcatelogid=" + alarmcatelogid +
                ", alarmnum=" + alarmnum +
                ", alarmdate=" + alarmdate +
                '}';
    }
}
