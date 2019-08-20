package com.neusoft.ribbon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ribbon.message.ResultMessage;
import com.neusoft.ribbon.model.RoleModel;
import com.neusoft.ribbon.service.IRoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	private IRoleService rs=null;
	@RequestMapping("/list")
	public ResultMessage<RoleModel> getList() throws Exception{
		ResultMessage<RoleModel> result=rs.getList();
		if(!result.getStatus().equals("ERROR")) {
			//取得页数
			//取得个数 result.setCount(rs.getCount());
			///
			
		}
		
		return result;
	}

}
