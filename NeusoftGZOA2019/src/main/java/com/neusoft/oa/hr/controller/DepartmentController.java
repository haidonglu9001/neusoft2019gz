package com.neusoft.oa.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.oa.hr.model.DepartmentModel;
import com.neusoft.oa.hr.service.IDepartmentService;
import com.neusoft.oa.message.ResultMessage;

/*
 * 模块：HR 人力资源
 * Controller层：部门控制器Controller类
 * @Author: 吕海东
 */
@RestController
@RequestMapping(value="/department")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService=null;
	
	//增加部门
	@RequestMapping("/add")
	public ResultMessage<DepartmentModel> add(DepartmentModel Department) throws Exception {
		departmentService.add(Department);
		return new ResultMessage<DepartmentModel>("OK","增加部门成功");
	}
	//修改部门
	@PostMapping("/modify")
	public ResultMessage<DepartmentModel> modify(DepartmentModel Department) throws Exception {
		departmentService.modify(Department);
		return new ResultMessage<DepartmentModel>("OK","修改部门成功");
	}
	//删除部门
	@PostMapping("/delete")
	public ResultMessage<DepartmentModel> delete(DepartmentModel Department) throws Exception {
		departmentService.delete(Department);
		return new ResultMessage<DepartmentModel>("OK","删除部门成功");
	}
	//取得指定的部门
	@GetMapping("/get")
	public ResultMessage<DepartmentModel> getByNo(int no) throws Exception{
		
		ResultMessage<DepartmentModel> result=new ResultMessage<DepartmentModel>("OK","取得部门成功");
		result.setModel(departmentService.getByNo(no));
		return result;
		
	}
	//取得所有部门列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<DepartmentModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<DepartmentModel> result=new ResultMessage<DepartmentModel>("OK","取得部门列表分页模式成功");
		result.setCount(departmentService.getCountByAll());
		result.setPageCount(departmentService.getPagaCountByAll(rows));
		result.setList(departmentService.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有部门列表，无分页
	@GetMapping(value="/list/all")
	public List<DepartmentModel> getListByAll() throws Exception{
		return departmentService.getListByAll();
	}
	//检查此部门能否被删除
	@GetMapping(value="/checkDelete")
	public ResultMessage<DepartmentModel> checkForDelete(int no) throws Exception{
		ResultMessage<DepartmentModel> result=new ResultMessage<DepartmentModel>("OK","此部门可以删除");
		if(!departmentService.checkCanDelete(no)) {
			result.setStatus("NO");
			result.setMessage("此部门不能删除");
		}
		return result;
	}
	

}
