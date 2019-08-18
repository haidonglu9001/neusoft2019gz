package com.neusoft.oa.hr.controller;

import java.util.List;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.oa.hr.model.DepartmentModel;
import com.neusoft.oa.hr.model.RoleModel;
import com.neusoft.oa.hr.service.IRoleService;
import com.neusoft.oa.message.ResultMessage;

/*
 * 模块：HR 人力资源
 * 角色控制层Controller
 * @Author: 吕海东
 */
@RestController
@RequestMapping(value="/role")
public class RoleController {

	@Autowired
	private IRoleService roleService=null;
	
	//增加角色
	@PostMapping("/add")
	public ResultMessage<RoleModel> add(RoleModel role) throws Exception {
		roleService.add(role);
		return new ResultMessage<RoleModel>("OK","增加角色成功");
	}
	//修改角色
	@PostMapping("/modify")
	public ResultMessage<RoleModel> modify(RoleModel role) throws Exception {
		roleService.modify(role);
		return new ResultMessage<RoleModel>("OK","修改角色成功");
	}
	//删除角色
	@PostMapping("/delete")
	public ResultMessage<RoleModel> delete(RoleModel role) throws Exception {
		roleService.modify(role);
		return new ResultMessage<RoleModel>("OK","删除角色成功");
	}
	//取得指定的角色
	@GetMapping(value="/get")
	public RoleModel getByNo(int no) throws Exception{
		return roleService.getByNo(no);
	}
	//取得所有角色列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<RoleModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		
		ResultMessage<RoleModel> result=new ResultMessage<RoleModel>("OK","取得角色列表分页模式成功");
		result.setCount(roleService.getCountByAll());
		result.setPageCount(roleService.getPagaCountByAll(rows));
		result.setList(roleService.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有角色列表，无分页
	@GetMapping(value="/list/all")
	public List<RoleModel> getListByAll() throws Exception{
		return roleService.getListByAll();
	}
}
