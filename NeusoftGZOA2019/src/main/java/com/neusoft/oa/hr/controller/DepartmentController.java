package com.neusoft.oa.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.oa.hr.model.DepartmentModel;
import com.neusoft.oa.hr.service.IDepartmentService;

/*
 * 模块：HR 人力资源
 * 部门控制层Controller
 * @Author: 吕海东
 */
@RestController
@RequestMapping(value="/department")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService=null;
	
	//增加部门
	
	//修改部门
	
	//删除部门
	
	//取得指定的部门
	
	//取得所有部门列表，有分页
	@GetMapping(value="/list/all/page")
	public List<DepartmentModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		return departmentService.getListByAllWithPage(rows, page);
	}
	
	//取得所有部门列表，无分页
	@GetMapping(value="/list/all")
	public List<DepartmentModel> getListByAll() throws Exception{
		return departmentService.getListByAll();
	}

}
