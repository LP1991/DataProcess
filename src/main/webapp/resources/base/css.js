	function getContextPath(){ 
		var pathName = document.location.pathname; 
		var index = pathName.substr(1).indexOf("/"); 
		var result = pathName.substr(0,index+1); 
		return result; 
	}
	var path = getContextPath();
//<!-- Bootstrap 3.3.2 -->
    document.write('<link href="'+path+'/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" >');    
// <!-- FontAwesome 4.3.0 -->
     document.write('<link href="'+path+'/resources/plugins/font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" >');
// <!-- Ionicons 2.0.0 -->
     document.write('<link href="'+path+'/resources/plugins/ionicons-2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" >');    
// <!-- Theme style -->
     document.write('<link href="'+path+'/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" >');
// <!-- AdminLTE Skins. Choose a skin from the css/skins
// folder instead of downloading all of them to reduce the load. -->
     document.write('<link href="'+path+'/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" >');
// <!-- iCheck -->
     document.write('<link href="'+path+'/resources/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" >');
     document.write('<link href="'+path+'/resources/plugins/iCheck/all.css" rel="stylesheet" rel="stylesheet" type="text/css" />');
// <!-- Morris chart -->
     document.write('<link href="'+path+'/resources/plugins/morris/morris.css" rel="stylesheet" type="text/css" >');
// <!-- jvectormap -->
     document.write('<link href="'+path+'/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" >');
// <!-- Date Picker -->
     document.write('<link href="'+path+'/resources/plugins/datepicker/datepicker3.css" rel="stylesheet" type="text/css" >');
// <!-- Datetime picker -->
     document.write('<link href="'+path+'/resources/plugins/datetimepicker/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css" >');
// <!-- Daterange picker -->
     document.write('<link href="'+path+'/resources/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" >');
// <!-- bootstrap wysihtml5 - text editor -->
     document.write('<link href="'+path+'/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" >');
// <!-- DATA TABLES -->
     document.write('<link href="'+path+'/resources/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />');
// <!-- Jquery-validate config default -->
     document.write('<link href="'+path+'/resources/views/common/validate-default.css" rel="stylesheet" type="text/css" />');
// <!-- datetimepicker -->
     document.write('<link href="'+path+'/resources/plugins/datetimepicker/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css" />');  
// <!-- bootbox css -->
     document.write('<link href="'+path+'/resources/views/common/bootbox.css" rel="stylesheet" type="text/css" />');