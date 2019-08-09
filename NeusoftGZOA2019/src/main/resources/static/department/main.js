/**
 * 部门的前端控制JS
 * 作者：吕海东
 * 
 */
$(function(){
	var rows=2;
	var page=1;
	var pageCount=0;

	//嵌入列表页面
	$("div#departmentmaincontent").load("department/list.html",function(){
		//操作列表的方法
		//取得部门的列表，分页模式
		function getListInfo(){
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
	});
	
	
	
	
});