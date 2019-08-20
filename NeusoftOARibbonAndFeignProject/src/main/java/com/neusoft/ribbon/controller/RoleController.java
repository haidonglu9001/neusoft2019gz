package com.neusoft.ribbon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ribbon.model.RoleModel;
import com.neusoft.ribbon.service.IRoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	private IRoleService rs=null;
	@RequestMapping("/list")
	public List<RoleModel> getList() throws Exception{
		return rs.getList();
	}

}
