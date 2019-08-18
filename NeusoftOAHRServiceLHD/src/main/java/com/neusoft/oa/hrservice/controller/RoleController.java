package com.neusoft.oa.hrservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.oa.hrservice.model.RoleModel;
import com.neusoft.oa.hrservice.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService=null;
	
	@GetMapping(value="/list/all")
	public List<RoleModel> getListByAll() throws Exception {
		
		return roleService.getListByAll();
	}
	

}
