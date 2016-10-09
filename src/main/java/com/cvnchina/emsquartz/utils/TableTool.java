package com.cvnchina.emsquartz.utils;

/**
 * Created by Primo on 2016/8/28.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.utils
 * COPYRIGHT BY CVNCHINA 2016.
 */
public class TableTool {
    public static String ne = "ne_";
    public static String alarmcatalog = "alarmcatalog_";
    public static String neinfostat = "neinfostat_";
    public static String netype = "netype_";
    public static String currentalarm = "currentalarm_";
    public static String rgroup = "rgroup_";

    public static String getSuffix(String tableName){
        if(tableName==null || tableName.length()==0){
            return null;
        }
        String[] tableAndSuf = tableName.split("_");
        if(tableAndSuf.length == 2){
            return tableAndSuf[1];
        }
        return null;
    }
    public static void main(String[] args){
        System.out.print(new TableTool().getSuffix("_"));
    }
}
