/* Set the defaults for DataTables initialisation */
$.extend(true, $.fn.dataTable.defaults, {
	"oLanguage" : {
//		"sLoadingRecords": "<h1>载入中....</h1>",
		"sProcessing" : "&nbsp;&nbsp;&nbsp;&nbsp;<li class='fa fa-spinner fa-spin'></li>正在加载中...",
		"sLengthMenu" : "_MENU_ 记录/页",
		"sZeroRecords" : "没有匹配的记录",
		"sEmptyTable" : "没有符合条件的记录",
		"sInfo" : "显示第 _START_ 至 _END_ 项记录，共 _TOTAL_ 项",
		"sInfoEmpty" : "显示第 0 至 0 项记录，共 0 项",
		"sInfoFiltered" : "(由 _MAX_ 项记录过滤)",
		"sInfoPostFix" : "",
		"sSearch" : "过滤:",
		"sUrl" : "",
		"oPaginate" : {
			"sFirst" : "首页",
			"sPrevious" : "上页",
			"sNext" : "下页",
			"sLast" : "末页"
		}
	}
});

jQuery.fn.extend( $.fn.dataTable.defaults, {
	fnHeaderCallback : function(nHead, aData, iStart, iEnd, aiDisplay) {
		$(nHead).css("background-color", "rgb(226, 226, 226)");
	}
});