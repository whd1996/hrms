$(document).ready( function(){
	var role=sessionStorage.getItem("userRole");
	var department=sessionStorage.getItem("userDepartment");
	console.log(department+","+role);
	
	/*if(role==3){
		$table.bootstrapTable('refresh',{"url" : "/hrms/user/listUser"});//总经理
	}else if(role==2){
		$table.bootstrapTable('refresh',{"url" : "/hrms/user/listUserByDepartment"});//经理
	}else if(role==1){
		$table.bootstrapTable('refresh',{"url" : "/hrms/user/listUserByZhuGuan"});//主管
	}else if(role==0){
		$table.bootstrapTable('refresh',{"url" : "/hrms/user/listUserByUserId"});//普通员工
	}
		*/
	
})