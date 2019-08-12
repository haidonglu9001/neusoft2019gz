/**
 * 部门的前端控制JS
 * 作者：吕海东
 * 
 */
$(function(){
	var rows=10;
	var page=1;
	var pageCount=0;
	//取得部门的列表，分页模式
	function getListInfo(){
		//调用后台取得部门列表REST API
		$.getJSON("department/list/all/page",{page:page,rows:rows},function(data){
				//显示个数和页数
				$("span#count").html(data.count);
				$("span#pagecount").html(data.page+"/"+data.pageCount);
				pageCount=data.pageCount;
				//显示列表
				$("table#DepartmentTable tbody").html("");
				for(var i=0;i<data.list.length;i++){
					var tr="<tr><td>"+data.list[i].code+"</td><td>"+data.list[i].name+"</td></tr>";
					$("table#DepartmentTable tbody").append(tr);
				}
		 });
	}	
	//定义分页导航链接处理事件
	$("div#page_nav a").on("click",function(event){
			  var action=$(this).attr("href");
			  event.preventDefault();
			  switch(action){
			  	case "top":
			  		page=1;
			  		getListInfo();
			  		break;
			  	case "pre":
			  		if(page>1){
			  			page=page-1;
			  			getListInfo();
			  		}
			  		break;
			  	case "next":
			  		if(page<pageCount){
			  			page=page+1;
			  			getListInfo();
			  		}
			  		break;
			  	case "last":
			  		page=pageCount;
			  		getListInfo();
			  		break;
			  }
		
	});
	
	//初始调用取得分页列表数据
	getListInfo();
	//点击增加链接处理，嵌入add.html
	$("a#DepartmentAddLink").off().on("click",function(event){
				
		$("div#DepartmentDialogArea").load("department/add.html",function(){
			$("div#DepartmentDialogArea" ).dialog({
				title:"增加部门",
				width:600
			});
			
			$("form#DepartmentAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					getListInfo(); 
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '部门操作信息',
		            message:result.message
		        });
				$("div#DepartmentDialogArea" ).dialog( "close" );
				$("div#DepartmentDialogArea" ).dialog( "destroy" );
				$("div#DepartmentDialogArea").html("");
				
			});
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$( "div#DepartmentDialogArea" ).dialog( "close" );
				$( "div#DepartmentDialogArea" ).dialog( "destroy" );
				$("div#DepartmentDialogArea").html("");
			});
		});
		
	});
	//点击修改按钮事件处理
	$("a#DepartmentModifyLink").off().on("click",function(event){
		
	});
	
	//点击删除按钮事件处理
	$("a#DepartmentDelteLink").off().on("click",function(event){
		
	});
	//点击查看详细按钮事件处理
	$("a#DepartmentViewLink").off().on("click",function(event){
		
		$("div#DepartmentDialogArea").load("department/view.html",function(){
			$("div#DepartmentDialogArea" ).dialog({
				title:"部门详细",
				width:600
			});
			
			
			//点击取消按钮处理
			$("input[value='返回']").on("click",function(){
				$( "div#DepartmentDialogArea" ).dialog( "close" );
				$( "div#DepartmentDialogArea" ).dialog( "destroy" );
				$("div#DepartmentDialogArea").html("");
			});
		});
	});
	
	
	
	
	
	
	
	
	
});