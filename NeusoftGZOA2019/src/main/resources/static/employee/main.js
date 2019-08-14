/**
 * 员工前端主管理JS
 * 模块：HR
 * 业务对象：员工
 * 作者:吕海东
 * 
 */
$(function(){
	var employeeId=null;
	var startJoinDate=null;
	var endJoinDate=null;
	var departmentNo=0;
	var roleNo=0;
	var sex="";
	//设置系统页面标题
	$("span#mainpagetille").html("员工管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#EmployeeGrid").jqGrid({
		url: host+'employee/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '账号', name: 'id', width: 75 },
			{ label: '姓名', name: 'name', width: 90 },
			{ label: '部门', name: 'department.name', width: 100 },
			{ label: '性别', name: 'sex', width: 40 },
			{ label: '年龄', name: 'age', width: 50},
			{ label: '出生日期', name: 'birthday', width: 70 },
			{ label: '入职日期', name: 'joinDate', width: 70 }   
		],
		caption:"员工列表",
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 20,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "id"},
		pager: "#EmployeeGridPager",
		multiselect:false,
		onSelectRow:function(empid){
			employeeId=empid;
		}
		
	});
	//取得部门列表，填充部门下拉框
	$.getJSON(host+"department/list/all",function(departmentList){
		if(departmentList){
			$.each(departmentList,function(index,dm){
				$("select#DepartmentSelection").append("<option value='"+dm.no+"'>"+dm.name+"</option>");
			});
		}
	});
	//取得角色列表，填充角色下拉框
	$.getJSON(host+"role/list/all",function(roleList){
		if(roleList){
			$.each(roleList,function(index,rm){
				$("select#RoleSelection").append("<option value='"+rm.no+"'>"+rm.name+"</option>");
			});
		}
	});
	//设置检索参数，更新jQGrid的列表显示
	function reloadEmployeeList()
	{
		$("table#EmployeeGrid").jqGrid('setGridParam',{postData:{departmentNo:departmentNo,roleNo:roleNo,sex:sex,startJoinDate:startJoinDate,endJoinDate:endJoinDate}}).trigger("reloadGrid");
		
	}
	
	//定义部门下拉框的更新事件的处理
	$("select#DepartmentSelection").off().on("change",function(){
		departmentNo=$("select#DepartmentSelection").val();
		reloadEmployeeList();
	});
	
	//定义性别单选按钮更改事件
	$("input[name='empsex']").off().on("change",function(){
		sex=$("input[name='empsex']:checked").val();
		reloadEmployeeList();
	});
	//点击检索事件处理
	$("a#EmployeeSearchButton").on("click",function(){
		departmentNo=$("select#DepartmentSelection").val();
		roleNo=$("select#RoleSelection").val();
		sex=$("input[name='empsex']:checked").val();
		
		startJoinDate=$("input#startJoinDate").val();
		endJoinDate=$("input#endJoinDate").val();
		if(startJoinDate==""){
			startJoinDate=null;
		}
		if(endJoinDate==""){
			endJoinDate=null;
		}
		reloadEmployeeList();
	});
	//===========================增加员工处理================================================
	$("a#EmployeeAddLink").off().on("click",function(){
		$("div#EmployeeDialog").load("employee/add.html",function(){
			//取得部门列表，并填充部门下拉框
			$.getJSON(host+"department/list/all",function(departmentList){
				if(departmentList){
					$.each(departmentList,function(index,dm){
						$("select[name='department.no']").append("<option value='"+dm.no+"'>"+dm.name+"</option>");
					});
				}
			});
			//取得角色列表，生成角色选择下拉框
			$.getJSON(host+"role/list/all",function(roleList){
				if(roleList){
					$.each(roleList,function(index,rm){
						$("div#RoleListForEMP").append("<input type='checkbox' name='employeeRoles' value='"+rm.no+"' />"+rm.name);
					});
				}
			});
			//验证员工提交数据
			$("form#EmployeeAddForm").validate({
				  rules: {
				    id: {
				      required: true,
				      remote: host+"employee/checkidexist"
				      
				    },
				    name:{
				    	required: true
				    },
				    age:{
				    	number: true,
				    	min:18,
				    	max:60,
				    	range: [18, 60]
				    },
				    mail:{
				    	required:true,
				    	email: true
				    },
				    mobile:{
				    	required:true,
				    	mobile:true
				    	
				    }
				  },
				  messages:{
					id: {
					      required: "账号为空",
					      remote:"账号已经存在"
					    },
					name:{
					    	required:"部门名称为空"
					},
					age:{
						number: "年龄必须是数值",
				    	range:"年龄需要在18和60之间"
					}
				 }
			});
			//拦截增加提交表单
			$("form#EmployeeAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadEmployeeList();//更新员工列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '员工操作信息',
		            message:result.message
		        });
				$("div#EmployeeDialog").dialog( "close" );
				$("div#EmployeeDialog").dialog( "destroy" );
				$("div#EmployeeDialog").html("");
				
			});
			
			
			$("div#EmployeeDialog").dialog({
				title:"员工增加",
				width:950
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#EmployeeDialog").dialog("close");
				$("div#EmployeeDialog").dialog("destroy")
				$("div#EmployeeDialog").html("");
			});
			
			
		});
		
	});
	
	//===============================修改员工处理===============================================================
	$("a#EmployeeModifyLink").off().on("click",function(){
		if(employeeId==null){
			BootstrapDialog.show({
	            title: '员工操作信息',
	            message:"请选择要修改的员工",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#EmployeeDialog").load("employee/modify.html",function(){
				//取得指定的员工信息
				$.getJSON(host+"/employee/get",{id:employeeId},function(em){
					if(em){
						$("span#employeeId").html(employeeId);
						$("span#employeeName").html(em.name);
						$("span#employeeSex").html(em.sex);
						$("span#empage").html(em.age);
						$("span#empsalary").html(em.salary);
						$("span#empbirthday").html(em.birthday);
						$("span#empjoindate").html(em.joinDate);
						$("span#departmentName").html(em.department.name);
						if(em.roles){
							$.each(em.roles,function(index,roleModel){
								$("span#emproles").append(roleModel.name+"  ");
							});
						}
						if(em.photoFileName!=null&&em.photoFileName!=""){
							$("span#empphoto").html("<img src='employee/downphoto?id="+employeeId+"' />");
						}
						else{
							$("span#empphoto").html("无照片");
						}
						
					}
				});
				$("div#EmployeeDialog").dialog({
					title:"员工修改",
					width:800
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='取消']").off().on("click",function(){
					$("div#EmployeeDialog").dialog("close");
					$("div#EmployeeDialog").dialog("destroy")
					$("div#EmployeeDialog").html("");
				});
				
				
			});
		}
	});
	//===============================删除员工处理==============================================================
	
	
	
	//================================查看员工处理=============================================================
	$("a#EmployeeViewLink").off().on("click",function(){
		if(employeeId==null){
			BootstrapDialog.show({
	            title: '员工操作信息',
	            message:"请选择要查看的员工",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#EmployeeDialog").load("employee/view.html",function(){
				//取得指定的员工信息
				$.getJSON(host+"/employee/get",{id:employeeId},function(em){
					if(em){
						$("span#employeeId").html(employeeId);
						$("span#employeeName").html(em.name);
						$("span#employeeSex").html(em.sex);
						$("span#empage").html(em.age);
						$("span#empsalary").html(em.salary);
						$("span#empbirthday").html(em.birthday);
						$("span#empjoindate").html(em.joinDate);
						$("span#departmentName").html(em.department.name);
						if(em.roles){
							$.each(em.roles,function(index,roleModel){
								$("span#emproles").append(roleModel.name+"  ");
							});
						}
						if(em.photoFileName!=null&&em.photoFileName!=""){
							$("span#empphoto").html("<img src='employee/downphoto?id="+employeeId+"' />");
						}
						else{
							$("span#empphoto").html("无照片");
						}
						
					}
				});
				
				
				$("div#EmployeeDialog").dialog({
					title:"员工详细",
					width:800
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='关闭']").off().on("click",function(){
					$("div#EmployeeDialog").dialog("close");
					$("div#EmployeeDialog").dialog("destroy")
					$("div#EmployeeDialog").html("");
				});
				
				
			});
		}
		
		
		
	});
	
	
	
	
});