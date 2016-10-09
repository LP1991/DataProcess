$(function () {
	
	
	$("a[href*='/lease/lease.html']").parent("li").addClass("active");
    
    var table = $('#table').dataTable( {
    	"bPaginate": true,
        "bLengthChange": true,
        "bFilter": false,
        "bSort": true,
        "bInfo": true,
        "bAutoWidth": false,
        "bRetrieve": true,
        "bStateSave": true,
    	"bServerSide": true,
    	"sScrollX": "1380px",
		"bScrollCollapse": true,
	    "sAjaxSource": "/zero/lease/query",
	    "sServerMethod": "POST",
	 	"aoColumns": [  
			{"sTitle": "IP地址",   "mData": "ipaddress"},
	 	 	{"sTitle": "MAC地址",   "mData": "clientmac"},
	 		{"sTitle": "Scope名称",   "mData": "scopename"},
	 		{"sTitle": "Policy名称",   "mData": "policyname"},
			{"sTitle": "Class名称",   "mData": "classname"},
			{"sTitle": "状态",   "mData": "status"},
	 		{"sTitle": "租约有效期",   "mData": "expiration"},
	 		{"sTitle": "最后一次心跳时间",   "mData": "lasthearttime"},
			{"sTitle": "协议类型",   "mData": "servertype"},
			{"sTitle": "客户端类型",   "mData": "clienttype"},
			{"sTitle": "重新下发管理参数",   "mData": "resendcmd"},
			{"sTitle": "分配IP时间","mData": "assignediptime"},
			{"sTitle": "分配IP次数","mData": "assignedipcount"}
	    ],
	 	"fnServerParams": function ( aoData ) {
			aoData.push( 
				{"name": "scopename", "value": $("#scopename").val()},
				{"name": "policyname", "value": $("#policyname").val()},
				{"name": "classname", "value": $("#classname").val()},
				{"name": "clientmac", "value": $("#clientmac").val()},
				{"name": "ipaddress1", "value": $("#ipaddress1").val()},
				{"name": "ipaddress2", "value": $("#ipaddress2").val()},
				{"name": "servertype", "value": $("#servertype").val()},
				{"name": "clienttype", "value": $("#clienttype").val()},
				{"name": "status", "value": $("#status").val()}
			); 
		},
		"aoColumnDefs" : [ {
			"aTargets" : [ 8],
			"sTitle": "协议类型",   "mData": "servertype",
			"mRender" : function(data, type, full) {
				return data==1?"DHCP":(data==2?"BCMP":"未知");
			}
		},{
			"aTargets" : [ 9],
			"sTitle": "客户端类型",   "mData": "clienttype",
			"mRender" : function(data, type, full) {
				return data==1?"局端":(data==2?"终端":"未知");
			}
		},{
			"aTargets" : [10],
			"sTitle": "重新下发管理参数",   "mData": "resendcmd",
			"mRender" : function(data, type, full) {
				if(data==0){
					return "否";
				}else if(data>=1 && data<=3){
					return "是";
				}else{
					return "未知";
				}
			}
		}]		
    });
    
    if($("table").parent().get(0).clientWidth<$("table").parent().parent().get(0).clientWidth){
    	$("table").parent().css("width","100%");
    }
    
//    $("button[type='submit']").click(function(){
////    	var setting = table.fnSettings();
////    	setting._iDisplayStart = 0;
////    	table._fnAjaxUpdate(setting);
//    	table.fnClearTable(0);
//    	table.fnDraw();
//    });
    
    $("#leasequeryform").validate({
		rules : {
			scopename : {
				maxlength : 32
			},
			policyname : {
				maxlength : 32
			},
			classname : {
				maxlength : 32
			},
			clientmac : {
				isMac:true
			},
			ipaddress1 : {
				isIpAddress : true
			},
			ipaddress2 : {
				isIpAddress : true,
				isIpRangeRight:"#ipaddress1"
			}
		},
		errorPlacement : function(error, element) {
			if (element.is(":radio"))
				error.appendTo(element.parent().next().next());
			else if (element.is(":checkbox"))
				error.appendTo(element.next());
			else
				error.appendTo(element.parent());
		},
		submitHandler : function(form) {
			table.fnClearTable(0);
			table.fnDraw();
		}
	});
    

});