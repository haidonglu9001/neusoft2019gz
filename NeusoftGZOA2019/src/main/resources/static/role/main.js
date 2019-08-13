/**
 * 前端主管理JS
 * 模块：HR
 * 业务对象：Role
 * 作者:吕海东
 * 
 */
$(function(){
	
	var roleNo=0;
	
	//设置系统页面标题
	$("span#mainpagetille").html("角色管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#RoleGrid").jqGrid({
		url: 'role/list/all/page',
		datatype: "json",
		colModel: [
			
			{ label: '角色名称', name: 'name', width: 200 }
			              
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
		      id: "no"},
		pager: "#RoleGridPager",
		onSelectRow:function(roleNo){
			
		}
		
	});
	
	
	
	
});