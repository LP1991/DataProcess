$.ajax({
	type : "POST",
	url : "/emsquartz/topo/getNeNum",
	dataType : "json",
	async : false,
	success : function(msg) {
		$("#leasenuminfo h3").text(msg.data);
	}
});
