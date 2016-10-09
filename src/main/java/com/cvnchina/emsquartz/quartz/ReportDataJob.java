package com.cvnchina.emsquartz.quartz;


import com.cvnchina.emsquartz.domain.AlarmlevelNum;
import com.cvnchina.emsquartz.domain.HebeiNeNum;
import com.cvnchina.emsquartz.domain.Rgroup;
import com.cvnchina.emsquartz.domain.Syncalarmstatdata;
import com.cvnchina.emsquartz.dataaccess.AlarmStatMapper;
import com.cvnchina.emsquartz.dataaccess.DeviceStatMapper;
import com.cvnchina.emsquartz.dataaccess.OnlineUserMapper;
import com.cvnchina.emsquartz.dataaccess.RgroupMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/***
 * syncalarmstatdata 更新本地组数据，存储缓存数据优化查询
 *
 */
public class ReportDataJob {
	private static List<Integer> average = new ArrayList<Integer>();
	private static String[] companyinfos = new String[]{"云视","华为","中兴","烽火","博达","金钱猫","高斯达","初灵","其他厂家"};
//	@Autowired
	private OnlineUserMapper onlineUserMapper;	
//	@Autowired
	private RgroupMapper rgroupMapper;
//	@Autowired
	private AlarmStatMapper alarmStatMapper;
//	@Autowired
	private DeviceStatMapper deviceStatMapper;

	/**
	 * 终端用户数统计 19-21点到统计3次去平均值
	 */
	public void execute() {
		try{
			int num = onlineUserMapper.getUserNum();
			average.add(num);
			if(average.size() == 3){
				int aver = 0;
				for(int i=0;i<average.size();i++){
					aver += average.get(i);
				};
				aver = (int) Math.ceil(aver/3.0);
				System.out.println(aver);
				Map<String,Object> map = new LinkedHashMap<String,Object>();
				map.put("usernum",aver);
				map.put("time",new Timestamp(System.currentTimeMillis()));
				onlineUserMapper.add(map);
				average = new ArrayList<Integer>();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 统计最上层告警数 插入到syncalarm表中
	 */
	public void addAlarmStatForGroup(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		List<Object> groups = rgroupMapper.getFirstGroups();
		System.out.println("groups:"+groups.size());
		if(groups!=null){
			for(int i=0;i<groups.size();i++){
				Rgroup group = (Rgroup)groups.get(i);
				List<Object> list= alarmStatMapper.getAlarmlevelNum(group.getGroupid());
				Syncalarmstatdata sasd = new Syncalarmstatdata();
				sasd.setStattime(timestamp);
				sasd.setAreacode(group.getGroupid().toString());
				init(sasd,list);
				System.out.println("sasd:"+sasd.getAreacode());
				alarmStatMapper.saveSyncAlarmStat(sasd);
			}
		}
	}

	/**
	 * 统计设备数量和故障设备数量
	 */
	public void addDeviceNum(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try{
			for(int i=0;i<companyinfos.length;i++){
				if(companyinfos[i].equals("云视")){
					String[] maxtype = new String[]{"50000","50104","1,6,10000","3,8"};
					String[] names = new String[]{"云视OLT","云视ONU","云视EOC局端","云视EOC终端"};
					queryDeviceNumAndAdd(companyinfos[i],maxtype,names,timestamp);
				}else if(companyinfos[i].equals("华为")){
					String[] maxtype = new String[]{"50000","50104"};
					String[] names = new String[]{"华为OLT","华为ONU"};
					queryDeviceNumAndAdd(companyinfos[i],maxtype,names,timestamp);
				}else if(companyinfos[i].equals("中兴")){
					String[] maxtype = new String[]{"50000","50104"};
					String[] names = new String[]{"中兴OLT","中兴ONU"};
					queryDeviceNumAndAdd(companyinfos[i],maxtype,names,timestamp);
				}else if(companyinfos[i].equals("烽火")){
					String[] maxtype = new String[]{"50000","50104"};
					String[] names = new String[]{"烽火OLT","烽火ONU"};
					queryDeviceNumAndAdd(companyinfos[i],maxtype,names,timestamp);
				}else if(companyinfos[i].equals("博达")){
					String[] maxtype = new String[]{"50000","50104"};
					String[] names = new String[]{"博达OLT","博达ONU"};
					queryDeviceNumAndAdd(companyinfos[i],maxtype,names,timestamp);
				}else if(companyinfos[i].equals("金钱猫")){
					String[] maxtype = new String[]{"1,6,10000","3,8"};
					String[] names = new String[]{"金钱猫EOC局端","金钱猫EOC终端"};
					queryDeviceNumAndAdd(companyinfos[i],maxtype,names,timestamp);
				}else if(companyinfos[i].equals("高斯达")){
					String[] maxtype = new String[]{"1,6,10000","3,8"};
					String[] names = new String[]{"高斯达EOC局端","高斯达EOC终端"};
					queryDeviceNumAndAdd(companyinfos[i],maxtype,names,timestamp);
				}else if(companyinfos[i].equals("初灵")){
					String[] maxtype = new String[]{"1,6,10000","3,8"};
					String[] names = new String[]{"初灵EOC局端","初灵EOC终端"};
					queryDeviceNumAndAdd(companyinfos[i],maxtype,names,timestamp);
				}else if(companyinfos[i].equals("其他厂家")){
					String[] maxtype = new String[]{"-1"};
					String[] names = new String[]{"其他厂家设备"};
					queryDeviceNumAndAdd(companyinfos[i],maxtype,names,timestamp);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void queryDeviceNumAndAdd(String companyinfo,String[] maxtype, String[] names,Timestamp timestamp) throws Exception{
		// TODO Auto-generated method stub
		if(maxtype == null || names == null || maxtype.length != names.length){
			return;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		for(int i=0;i<maxtype.length;i++){
			map.clear();
			if(!maxtype[i].equals("-1")){
				map.put("maxtype", maxtype[i]);
			}
			map.put("companyinfo", companyinfo);
			
			int deviceNum = deviceStatMapper.getDeviceNum(map);
			if(deviceNum == 0){
				continue;
			}
			map.put("nestatus", "1");
			int alarmNum = deviceStatMapper.getDeviceNum(map);
			System.out.println("companyinfo:"+companyinfo+maxtype[i]);
			System.out.println("deviceNum:"+deviceNum);
			System.out.println("alarmNum:"+alarmNum);
			HebeiNeNum hebeiNe = new HebeiNeNum();
			hebeiNe.setCompanyinfo(names[i]);
			hebeiNe.setNealarmnum(alarmNum);
			hebeiNe.setCratetime(timestamp);
			hebeiNe.setNenum(deviceNum);
			deviceStatMapper.addDeviceNum(hebeiNe);
		}
	}

	private void init(Syncalarmstatdata sasd,List<Object> list) {
		for(int i=0;i<list.size();i++){
			AlarmlevelNum num = (AlarmlevelNum)list.get(i);
			switch(num.getAlarmlevelid()){
				case 1:
					sasd.setAlarmlevel1(num.getNum());
					break;
				case 2:
					sasd.setAlarmlevel2(num.getNum());
					break;
				case 3:
					sasd.setAlarmlevel3(num.getNum());
					break;
				case 4:
					sasd.setAlarmlevel4(num.getNum());
					break;
				case 5:
					sasd.setAlarmlevel5(num.getNum());
					break;
				case 6:
					sasd.setAlarmlevel6(num.getNum());
					break;
				case 7:
					sasd.setAlarmlevel7(num.getNum());
					break;			
			}
		}
		if(sasd.getAlarmlevel1()==null){
			sasd.setAlarmlevel1(0);
		}
		if(sasd.getAlarmlevel2()==null){
			sasd.setAlarmlevel2(0);
		}
		if(sasd.getAlarmlevel3()==null){
			sasd.setAlarmlevel3(0);
		}
		if(sasd.getAlarmlevel4()==null){
			sasd.setAlarmlevel4(0);
		}
		if(sasd.getAlarmlevel5()==null){
			sasd.setAlarmlevel5(0);
		}
		if(sasd.getAlarmlevel6()==null){
			sasd.setAlarmlevel6(0);
		}
		if(sasd.getAlarmlevel7()==null){
			sasd.setAlarmlevel7(0);
		}
	}
}