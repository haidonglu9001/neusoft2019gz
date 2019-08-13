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
		url: 'employee/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '账号', name: 'id', width: 75 },
			{ label: '姓名', name: 'name', width: 90 },
			{ label: '部门', name: 'department.name', width: 100 },
			{ label: '性别', name: 'sex', width: 40 },
			{ label: '年龄', name: 'age', width: 50},
			{ label: '生日', name: 'birthday', width: 100 }                   
		],
		viewrecords: true, 
		autowidth: true,
		height: 300,
		rowNum: 20,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "id"},
		pager: "div#EmployeeGridPager",
		
	});
	//更新jQGrid的列表显示
	function reloadEmployeeList()
	{
		$("table#EmployeeGrid").jqGrid('setGridParam',{postData:{departmentNo:departmentNo,roleNo:roleNo,sex:sex,startJoinDate:startJoinDate,endJoinDate:endJoinDate}}).trigger("reloadGrid");
		
	}
	
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
	
	
});