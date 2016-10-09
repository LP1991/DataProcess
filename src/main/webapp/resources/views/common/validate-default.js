var returnmsg = '';

jQuery.extend(jQuery.validator.messages, {
	required : "该字段为必选字段",
	remote : "请修正该字段",
	email : "请输入正确格式的电子邮件",
	url : "请输入合法的网址",
	date : "请输入合法的日期",
	dateISO : "请输入合法的日期 (ISO).",
	number : "请输入合法的数字",
	digits : "只能输入正整数",
	creditcard : "请输入合法的信用卡号",
	equalTo : "请再次输入相同的值",
	accept : "请输入拥有合法后缀名的字符串",
	maxlength : jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
	minlength : jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
	rangelength : jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
	range : jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
	max : jQuery.validator.format("请输入一个最大为{0} 的值"),
	min : jQuery.validator.format("请输入一个最小为{0} 的值")
});
//公有的校验方法
jQuery.validator.addMethod("isIpAddress", function(value, element) {
	var tel = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
	return this.optional(element) || (tel.test(value));
}, "请正确填写您的IP地址");
jQuery.validator.addMethod("isIpMaskAddress", function(value, element) {
	var ipconfigs = value.split("/");//ipconfig[0]为IP地址，ipconfig[1]为子网掩码位数
	returnmsg = "请正确填写您的IP地址";
	if(ipconfigs.length!=2){
		returnmsg = "请正确填写您的子网，例如：192.168.13.1/24";
		return false;
	}
	if(isNaN(ipconfigs[1]) || ipconfigs[1]<1 || ipconfigs[1]>31){
		returnmsg = "子网掩码的范围是 1-31";
		return false;
	}
	
	var tel = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
	return this.optional(element) || (tel.test(ipconfigs[0]));
}, function(){return returnmsg;});
jQuery.validator.addMethod("isMac", function(value, element) {
	var tel = /^(([a-fA-F\d]{2}-[a-fA-F\d]{2}-[a-fA-F\d]{2}-[a-fA-F\d]{2}-[a-fA-F\d]{2}-[a-fA-F\d]{2})|([a-fA-F\d]{2}:[a-fA-F\d]{2}:[a-fA-F\d]{2}:[a-fA-F\d]{2}:[a-fA-F\d]{2}:[a-fA-F\d]{2}))$/;
	return this.optional(element) || (tel.test(value));
}, "请正确填写您的Mac地址  例如aa-aa-aa-aa-aa-aa或者aa:aa:aa:aa:aa:aa");

jQuery.validator.addMethod("exceptChineaseAndSpecialSign", function(value, element) {
	var tel = /^[^\u4e00-\u9fa5?/\*:|\"<>]+\.[a-zA-Z]+$/;
	return this.optional(element) || (tel.test(value));
}, "请正确输入文件名，此处不允许输入中文和特殊符合( ?/\*:|\"<> )");



//私有的校验方法
jQuery.validator.addMethod("isIpRangeAvailable", function(value, element,param) {//value表示this对应的值；element表示当前监控的对象，即this；param表示前台传递过来的其他数据，可以为一个对象或者array
	var id=null;
	var start=null;
	if(param.length>2){
		start=$(param[0]).val();
		id=$(param[1]).val();
		scopeid=$(param[2]).val();
	}else{
		start=$(param[0]).val();
		scopeid=$(param[1]).val();
		if(scopeid==null || scopeid==""){
			returnmsg = '请选择Scpoe';
			return false;
		}
	}
	
	if(start!=null && start!=""){
		var tel = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
		if(!(this.optional(element) || (tel.test(start)))){//校验结束IP的时候还要先校验初始IP是否符合规范，避免传递到后台的值有误			
//			returnmsg = '请正确填写您的IP地址';
			return this.optional(element) || (tel.test(start));
		}
	}
	
	var success=false;
	 $.ajax({
		   url: "/views/iprange/isIpRangeAvailable",
		   processData: false,
		   type:"POST",
           async:false,
		   dataType:'json',
		   data: "start="+start+"&end="+value+"&id="+id+"&scopeid="+scopeid,
		   success : function(data){ 
			   success=data.data;
			   if(data.msg!=""){
				   returnmsg = data.msg;
			   }else{
				   returnmsg = 'IP段已存在';
			   }
	          }
		 });
	return success;
}, function(){return returnmsg;});
jQuery.validator.addMethod("isMacAvailable", function(value, element,param) {
	var id=null;
	if(param==true){
	}else if(param){
		id=$(param).val();
	}
	var success=false;
	 $.ajax({
		   url: "/views/whitelist/isMacAvailable",
		   processData: false,
		   type:"POST",
           async:false,
		   dataType:'json',
		   data: "mac="+value+"&id="+id,
		   success : function(data){ 
			   success=data.data;
	          }
		 });
	return success;
}, "Mac地址已存在");
jQuery.validator.addMethod("isIpRangeRight", function(value, element,param) {
	if(value==''){
		return true;
	}
	return _ip2int(value)>=_ip2int($(param).val());
}, "IP段终止值需不小于IP段起始值");
jQuery.validator.addMethod("leader", function(value, element,param) {//value表示this对应的值；element表示当前监控的对象，即this；param表示前台传递过来的其他数据，可以为一个对象或者array
	var val=$(param.target).val();
	for (var i = 0; i < param.value.length; i++) {
		if(value==param.value[i].value&&(val==null||val=="")){
			$($(element).parent().parent().next("tr").children().get(1)).children("label").remove(".error");//通过get方法获取的对象已经不为一个集合，故不再支持children方法，则要重新外面套一层$(对象或者获取对象的条件)
			$(element).parent().parent().next("tr").children().get(1).innerHTML=$(element).parent().parent().next("tr").children().get(1).innerHTML+"<label class=\"error\" style=\"text-shadow: gray 2px 2px 2px; color:#DB3AF5;\">"+param.value[i].message+"</label>";
			return true;
		}
	}
	
	if(val==""||val=="null"){
		$($(element).parent().parent().next("tr").children().get(1)).children("label").remove(".error");
		$(element).parent().parent().next("tr").children().get(1).innerHTML=$(element).parent().parent().next("tr").children().get(1).innerHTML+"<label class=\"error\">请先选择Trap版本</label>";
		return false;
	}
	return true;
}, $.validator.format("请选择"));

//是否能被某个数整除
jQuery.validator.addMethod("divisible", function(value, element,param) {
	if(value%param==0){
		return true;
	}else{
		return false;
	}
},"该数不能被整除");

//vlantag属性相关判断
jQuery.validator.addMethod("vlantag", function(value, element,param) {
	var v = value;
	var vcs = v.split(",");
	var vs;
	var vsint;
	var min = 0;
	var max = 4094;
	
	if(v==''){
		return true;
	}
	
	if(param!=null && param.min!=null){
		min = param.min;
	}
	if(param!=null && param.max!=null){
		max = param.max;
	}
	
	if(v.indexOf('.')>-1){//判断不为小数
		returnmsg = '保留VLAN格式不正确，请参照如下格式：10,20-30,40,50 。';
		return false;
	}
	
	for(var j=0;j<vcs.length;j++){
		if(vcs[j]==""){
			returnmsg = '保留VLAN格式不正确，请参照如下格式：10,20-30,40,50 。';
			return false;
		}
		vs = vcs[j].split("-");
		vsint = new Array();
		for(var i=0; i<vs.length; i++){
			if(!isNaN(vs[i])){
				vsint[i] = parseInt(vs[i]);
				if(vsint[i]<min || vsint[i]>max){
					returnmsg = '正确范围['+min+','+max+']';
					return false;
				}
			}else{
				returnmsg = '保留VLAN格式不正确，请参照如下格式：10,20-30,40,50 。';
				return false;
			}
		}
		if(vsint.length==1){
			//return true;
		}else if(vsint.length==2){
			if(vsint[1]>vsint[0]){
				//return true;
			}else{
				returnmsg = '保留VLAN格式不正确，请参照如下格式：10,20-30,40,50 。';
				return false;
			}
		}else{
			returnmsg = '保留VLAN格式不正确，请参照如下格式：10,20-30,40,50 。';
			return false;
		}
	}
	
	return true;
}, function(){return returnmsg;});

//根据param传过来的ID统计vlantag总数
jQuery.validator.addMethod("vlantag_total", function(value, element,param) {
	var v = value;
	var vlanids = '';
	var vlanlist;
	
	if(param == 'vlan_tag'){		
		vlanlist = qinqvlanlist_change(v);
		if(vlanlist.length>10){
			returnmsg = '该端口VLAN List所包含的VLAN总数不可超过10个！';
			return false;
		}
		for(var i=1; i<=4; i++){
			if($("[name='vlan_tag_"+i+"']").val()!=''){
				vlanids=vlanids!=''?(vlanids+','+$("[name='vlan_tag_"+i+"']").val()):$("[name='vlan_tag_"+i+"']").val();
			}
		}
		if(qinqvlanlist_change(vlanids).length>16){
			returnmsg = '所有端口VLAN List所包含的VLAN总数不可超过16个！';
			return false;
		}
	}else if(param == 'mix_vlan_tag'){		
		vlanlist = qinqvlanlist_change(v);
		if(vlanlist.length>10){
			returnmsg = '该端口VLAN List所包含的VLAN总数不可超过10个！';
			return false;
		}
		for(var i=1; i<=2; i++){
			if($("[name='mix_vlan_tag_"+i+"']").val()!=''){
				vlanids=vlanids!=''?(vlanids+','+$("[name='mix_vlan_tag_"+i+"']").val()):$("[name='mix_vlan_tag_"+i+"']").val();
			}
		}
		if(qinqvlanlist_change(vlanids).length>16){
			returnmsg = '所有端口VLAN List所包含的VLAN总数不可超过16个！';
			return false;
		}
	}
	
	return true;
}, function(){return returnmsg;});

//tag和untag中校验元素不能重复
jQuery.validator.addMethod("taganduntaglistcheck", function(value, element,param) {
	var tagid = param.tagid;
	var untagid = param.untagid;
	var tag = $("#"+tagid).val();
	var untag = $("#"+untagid).val();
	
	var vlan = result_arrayget(qinqvlanlist_change(tag), qinqvlanlist_change(untag), 1);//获取tag和untag分别去重后两集合的交集
	
	if(vlan.length>0){
		returnmsg = 'tag和untag中的vlan不能重复';
		return false;
	}
	return true;
},function(){return returnmsg;});

//检查桥接模式下的vlan不能重复
jQuery.validator.addMethod("vlanbridgecheck", function(value, element, param) {
	var id = param.id;
	var index = param.index;
	var vlanStr = '';
	var vlanArray = new Array();
	if(id==('wan_vlan_'+index)){//WAN模板配置
		if($('#wan_mode_'+index).val()=='bridge'){			
			for(var i=1; i<=4; i++){
				if($('#wan_mode_'+i).val()=='bridge' && i!=index){
					if(value==$('#wan_vlan_'+i).val()){
						returnmsg = '桥接模式下的vlan不能重复';
						return false;
					}
				}
			}
		}
	}else if(id==('mix_wan_vlan_'+index)){//WAN模板配置(混合)
		if($("#mix_wan_mode_"+index).val()=='bridge'){			
			for(var i=1; i<=4; i++){
				if($('#mix_wan_mode_'+i).val()=='bridge' && i!=index){
					if(value==$('#mix_wan_vlan_'+i).val()){
						returnmsg = '桥接模式下的vlan不能重复';
						return false;
					}
				}
			}
		}
	}
	
	return true;
},function(){return returnmsg;});

//速率范围特殊判断
jQuery.validator.addMethod("wan_up_rate", function(value, element,param) {
	if(value=='' || value==0 || (value>=32 && value<=50000)){
		return true;
	}
	return false;
},"值范围32-50000,0表示不限制");

//认证配置参数校验
jQuery.validator.addMethod("automodify_validate", function(value, element,param) {
	returnmsg = '格式不正确，请修改！';
	if(param.type==0){
		returnmsg = "格式不正确，正确格式为'cn=Directory Manager'";
		if(value.indexOf('cn=')==0){
			return true;
		}
	}else if(param.type==1){
		returnmsg = "格式不正确，正确格式为'dc=laketune,dc=com'";
		if(value.indexOf(',')>-1){
			var dc = value.split(',');
			if(dc.length==2){
				if(dc[0].indexOf('dc=')==0 && dc[1].indexOf('dc=')==0){
					return true;
				}
			}
		}
	}
	
	return false;
},function(){return returnmsg;});

//option中值的格式校验
jQuery.validator.addMethod("optioncheck", function(value, element,param) {
//	$("#"+param).get(0).selectedIndex
	var text = $("#"+param).get(0).options[$("#"+param).get(0).selectedIndex].text;
	if(text=='' || text==null){
		return true;
	}
	returnmsg = "格式不正确，请修改！";
	if(text.indexOf('IP Address')>-1){
		returnmsg = "格式不正确，请正确填写一个IP地址！";
		var tel = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
		return this.optional(element) || (tel.test(value));
	}else if(text.indexOf('Boolean')>-1){
		var tel = /^0|([1-9]\d*)$/;
		if(!tel.test(value)){
			returnmsg = "格式不正确，请正确填写一个整数值，0或1！";
			return false;
		}
		if(value!=0 && value!=1){
			returnmsg = "格式不正确，请正确填写一个整数值，0或1！";
			return false;
		}
	}else if(text.indexOf('String')>-1 || text.indexOf('Snmp SafeName')>-1){
		if(value.length>32){
			returnmsg = "请输入 一个长度介于 0 和 32 之间的字符串！";
			return false;
		}
	}else if(text.indexOf('Unsigned 16bit')>-1 || text.indexOf('Snmp Port')>-1 || text.indexOf('Unsigned Time')>-1 || text.indexOf('Heart Interval')>-1 || text.indexOf('Template No')>-1){
		var tel = /^0|([1-9]\d*)$/;
		if(!tel.test(value)){
			returnmsg = "请输入一个介于 0 和 65535 之间的值！";
			return false;
		}
		if(value>65535 || value<0){
			returnmsg = "请输入一个介于 0 和 65535 之间的值！";
			return false;
		}
	}else if(text.indexOf('Snmp Version')>-1){
		var tel = /^0|([1-9]\d*)$/;
		if(!tel.test(value)){
			returnmsg = "格式不正确，请正确填写一个整数值，[1,3]！";
			return false;
		}
		if(value!=1 && value!=2 && value!=3){
			returnmsg = "格式不正确，请正确填写一个整数值，[1,3]！";
			return false;
		}
	}
	
	return true;
},function(){return returnmsg;});

//Client Mac Validate
jQuery.validator.addMethod("isClientMacAvailable", function(value, element,param) {
	var id=null;
	if(param==true){
	}else if(param){
		id=$(param).val();
	}
	var success=false;
	$.ajax({
		  url: "/views/client/isMacAvailable",
		  processData: false,
		  type:"POST",
          async:false,
		  dataType:'json',
		  data: "mac="+value+"&id="+id,
		  success : function(data){ 
			  success=data.data;
	      }
		 });
	return success;
}, "Mac地址已存在");

//Clientclass Name Validate
jQuery.validator.addMethod("isClientclassNameAvailable", function(value, element,param) {
	var id=null;
	if(param==true){
	}else if(param){
		id=$(param).val();
	}
	var success=false;
	$.ajax({
		  url: "/views/clientclass/isNameAvailable",
		  processData: false,
		  type:"POST",
          async:false,
		  dataType:'json',
		  data: "name="+value+"&id="+id,
		  success : function(data){ 
			  success=data.data;
	      }
		 });
	return success;
}, "名称已存在");

//Policy Name Validate
jQuery.validator.addMethod("isPolicyNameAvailable", function(value, element,param) {
	var id=null;
	if(param==true){
	}else if(param){
		id=$(param).val();
	}
	var success=false;
	$.ajax({
		  url: "/views/policy/isNameAvailable",
		  processData: false,
		  type:"POST",
          async:false,
		  dataType:'json',
		  data: "name="+value+"&id="+id,
		  success : function(data){ 
			  success=data.data;
	      }
		 });
	return success;
}, "名称已存在");

jQuery.validator.addMethod("isStaticIpMacAvailable", function(value, element,param) {
	var id=null;
	if(param==true){
	}else if(param){
		id=$(param).val();
	}
	var success=false;
	$.ajax({
		  url: "/views/staticip/isMacAvailable",
		  processData: false,
		  type:"POST",
          async:false,
		  dataType:'json',
		  data: "mac="+value+"&id="+id,
		  success : function(data){ 
			  success=data.data;
	      }
		 });
	return success;
}, "Mac地址已存在");

jQuery.validator.addMethod("isStaticIpIpAvailable", function(value, element,param) {
	var id=null;
	if(param==true){
	}else if(param){
		id=$(param).val();
	}
	var success=false;
	$.ajax({
		  url: "/views/staticip/isIpAvailable",
		  processData: false,
		  type:"POST",
          async:false,
		  dataType:'json',
		  data: "ip="+value+"&id="+id,
		  success : function(data){ 
			  success=data.data;
	      }
		 });
	return success;
}, "Ip地址已存在");

//Template Name Validate
jQuery.validator.addMethod("isTemplateNameAvailable", function(value, element,param) {
	var id=null;
	if(param==true){
	}else if(param){
		id=$(param).val();
	}
	var success=false;
	$.ajax({
		  url: "/views/template/isNameAvailable",
		  processData: false,
		  type:"POST",
          async:false,
		  dataType:'json',
		  data: "name="+value+"&id="+id,
		  success : function(data){ 
			  success=data.data;
	      }
		 });
	return success;
}, "名称已存在");

