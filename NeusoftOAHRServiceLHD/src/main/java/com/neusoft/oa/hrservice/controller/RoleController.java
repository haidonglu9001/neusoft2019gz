package com.neusoft.oa.hrservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.oa.hrservice.message.ResultMessage;
import com.neusoft.oa.hrservice.model.RoleModel;
import com.neusoft.oa.hrservice.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService=null;
	@PostMapping(value="/add")
	public ResultMessage<RoleModel> add(RoleModel rm) throws Exception {
		ResultMessage<RoleModel> result=new ResultMessage<RoleModel>("OK","增加角色成功");
		roleService.add(rm);
		return result;
	}
	
	@PostMapping(value="/modify")
	public ResultMessage<RoleModel> modify(RoleModel rm) throws Exception {
		ResultMessage<RoleModel> result=new ResultMessage<RoleModel>("OK","修改角色成功");
		roleService.modify(rm);
		return result;
	}
	
	
	@GetMapping(value="/list/all")
	public List<RoleModel> getListByAll() throws Exception {
		
		return roleService.getListByAll();
	}
	

}
