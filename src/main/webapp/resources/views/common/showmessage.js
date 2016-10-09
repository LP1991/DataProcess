//删除消息提示
function showMessage(fun, id){
	bootbox.confirm({
		title: '消息提示',
	    size: 'small',
	    locale: 'zh_CN',//设置按钮样式(中文还是英文)
	    keyboard: false,//设置esc按钮是否有效
	    backdrop: true,//点击外部时模态框是否消失
	    message: "<li class='fa fa-warning' style='font-size:35px;'></li></h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确认删除该项记录？",
	    callback: function(result){
	    	if(result){
	    		fun(id);
	    	}
		}
	});
}

function showMessageWithMessageEdited(fun, id,message){
	bootbox.confirm({
		title: '消息提示',
	    size: 'small',
	    locale: 'zh_CN',//设置按钮样式
	    message: "<li class='fa fa-warning' style='font-size:35px;'></li></h2><br><br><div style=\"text-align: center;\">"+message+"</div>", 
	    callback: function(result){
	    	if(result){
	    		fun(id);
	    	}
		}
	});
}

function showDelValidateMsg(msg){
	bootbox.alert({
		title: '消息提示',
	    size: 'small',
	    locale: 'zh_CN',//设置按钮样式(中文还是英文)
	    keyboard: false,//设置esc按钮是否有效
	    backdrop: true,//点击外部时模态框是否消失
	    message: msg, 
	    callback: function(){ /* your callback code */ }
	});
}