$(function () {


	$("a[href*='/lease/lease.html']").parent("li").addClass("active");

	var table = $('#table').dataTable( {
		"bPaginate": true,
		"bLengthChange": true,
		"bFilter": true,
		"bSort": true,
		"bInfo": true,
		"bAutoWidth": false,
		"bRetrieve": true,
		"bStateSave": true,
		"bServerSide": true,
		"sScrollX": "1380px",
		"bScrollCollapse": true,
		"sAjaxSource": "product/list",
		"sServerMethod": "POST",
		"sAjaxDataProp":"data",
        // "sAjaxDataProp" : "aData",
		"aoColumns": [
			{"sTitle": "名称",   "mData": "name"},
			{"sTitle": "描述",   "mData": "description"}
		],
		"fnServerParams": function ( aoData ) {
			aoData.push(
				{"name": "product.name", "value": $("#name").val()},
				{"name": "product.description", "value": $("#description").val()}
			);
		},
        "aoColumnDefs": [//给每个单独的列设置不同的填充，或者使用aoColumns也行
            { "bSortable": false, "aTargets": [0,1] },{
                "sDefaultContent" : '',
                "aTargets" : [ '_all' ]
            }
        ]
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