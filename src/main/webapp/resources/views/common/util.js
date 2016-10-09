//IP转成整型
function _ip2int(ip) 
{
    var num = 0;
    ip = ip.split(".");
    num = Number(ip[0]) * 256 * 256 * 256 + Number(ip[1]) * 256 * 256 + Number(ip[2]) * 256 + Number(ip[3]);
    num = num >>> 0;
    return num;
}
//整型解析为IP地址
function _int2iP(num) 
{
    var str;
    var tt = new Array();
    tt[0] = (num >>> 24) >>> 0;
    tt[1] = ((num << 8) >>> 24) >>> 0;
    tt[2] = (num << 16) >>> 24;
    tt[3] = (num << 24) >>> 24;
    str = String(tt[0]) + "." + String(tt[1]) + "." + String(tt[2]) + "." + String(tt[3]);
    return str;
}
//form样式重置功能，checkids为要重置的组件的ID集合
function form_clearcheck(checkids){
	var ids = new Array();
	ids = checkids.split(",");

	for(var i=0; i<ids.length; i++){
//		$("#"+id)[0].reset();
		$("#"+ids[i]).valid();
		$("#"+ids[i]+" .error").removeClass("error");
	}
	
}

//将例如2-4,5,7之类的数据转化为2,3,4,5,7，并去重
function qinqvlanlist_change(vlanlist){
	var list = vlanlist.split(',');
	var strlist = [];
	
	for(var i=0; i<list.length; i++){
		if(list[i].indexOf('-')>-1){
			var list2 = list[i].split('-');
			for(var j=parseInt(list2[0]); j<=parseInt(list2[1]); j++){
				strlist.push(j);
			}
		}else{
			strlist.push(list[i]);
		}
	}
		
	return distinctArray(strlist);//返回去重后的数组
}

//将例如2,3,4,5,7之类的数据转化为2-4,5,7，并去重
function qinqvlanlist_reversal(vlanlist){
	var val = "";
	if(vlanlist ==null || vlanlist.length == 0){
		return val;
	}
	
	var v1 = 0;
	var v2 = 0;
	for(var i=0;i<vlanlist.length;i++){
		var vlan = parseInt(vlanlist[i]);
		if(v1==0){
	 		v1 = vlan;
	 		v2 = vlan;
	 		continue;
		}
		if(vlan==v2+1){
			v2 = vlan;
		}else{
			if(v1==v2){
				val +=(val.length>0?",":"")+v1;
			}else{
				val +=(val.length>0?",":"")+(v1+"-"+v2);
			}
			
			v1 = vlan;
			v2 = vlan;
		}
	}
	
	if(v1>0 && v2>0){
		if(v1==v2){
			val +=(val.length>0?",":"")+v1;
		}else{
			val +=(val.length>0?",":"")+(v1+"-"+v2);
		}
	}
	return val;
}

//对数组中的元素进行简单去重
function distinctArray(arr){
	var obj={},temp=[];
	for(var i=0;i<arr.length;i++){
		if(!obj[arr[i]]){
			temp.push(arr[i]);
			obj[arr[i]] =true;
		}
	}
	return temp;
}

//取两集合相同元素或者不同元素
function result_arrayget(setmap, getmap, inorout){
	var obj = {};
	var resultmap0 = [];//存放存在于setmap但不存在于getmap中的元素
	var resultmap1 = [];//存放同时存在于setmap和getmap中的元素
	var resultstr0 = '';
	var resultstr1 = '';
	
	for(var i=0; i<getmap.length; i++){//先将getmap中的数组元素放到obj中
		if(!obj[getmap[i]]){
			obj[getmap[i]] = true;
		}
	}
	
	for(var i=0; i<setmap.length; i++){//通过和obj中的元素进行比较来赋值
		if(!obj[setmap[i]]){
			obj[setmap[i]] = true;
			resultmap0.push(setmap[i]);
		}else{
			resultmap1.push(setmap[i]);
		}
	}
	
	for(var i=0;i<resultmap0.length; i++){
		resultstr0+=(','+resultmap0[i]);
	}
	for(var i=0;i<resultmap1.length; i++){
		resultstr1+=(','+resultmap1[i]);
	}
	
	if(inorout==0){
		return resultstr0.substring(1);
	}else{
		return resultstr1.substring(1);
	}
}

//js补零函数
function toSpeclen(num,len){ 
    if(num.toString().length >= len){
   	 return num;
    }
    
    return toSpeclen("0"+num,len);
}