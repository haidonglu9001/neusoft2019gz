package com.neusoft.oa.hr.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.oa.hr.model.DepartmentModel;
import com.neusoft.oa.hr.model.EmployeeModel;

import com.neusoft.oa.hr.service.IEmployeeService;
import com.neusoft.oa.message.ResultMessage;

/*
 * 模块：HR 人力资源
 * Controller层：员工控制器Controller类
 * @Author: 吕海东
 */
@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService=null;
	
	//增加员工
	@RequestMapping("/add")
	public ResultMessage<EmployeeModel> add(EmployeeModel employee,@RequestParam(required = false) MultipartFile employeePhoto) throws Exception {
		if(employeePhoto!=null && (!employeePhoto.isEmpty())) {
			employee.setPhotoFileName(employeePhoto.getOriginalFilename());
			employee.setPhotoContentType(employee.getPhotoContentType());
			employee.setPhoto(employeePhoto.getBytes());
			employeeService.addWithPhoto(employee);
		}
		else {
			employeeService.add(employee);
		}
		
		return new ResultMessage<EmployeeModel>("OK","增加员工成功");
	}
	//修改员工
	//图片选项：KEEP 保持图片不变； CHANGE:修改  ; DELETE: 删除
	@PostMapping("/modify")
	public ResultMessage<EmployeeModel> modify(EmployeeModel employee,@RequestParam(required = false) MultipartFile employeePhoto,@RequestParam(required=false,defaultValue ="KEEP") String photoOption) throws Exception {
		
		if(employeePhoto!=null && (!employeePhoto.isEmpty())&&photoOption.equals("CHANGE")) {
			employee.setPhotoFileName(employeePhoto.getOriginalFilename());
			employee.setPhotoContentType(employee.getPhotoContentType());
			employee.setPhoto(employeePhoto.getBytes());
			employeeService.modifyWithPhoto(employee);
		}
		else {
			employeeService.modify(employee);
		}
		if(photoOption.equals("DELETE")) {
			employeeService.modifyForDeletePhoto(employee); //只删除员工的图片
		}
		return new ResultMessage<EmployeeModel>("OK","修改员工成功");
	}
	//删除员工
	@PostMapping("/delete")
	public ResultMessage<EmployeeModel> delete(EmployeeModel employee) throws Exception {
		employeeService.delete(employee);
		return new ResultMessage<EmployeeModel>("OK","删除员工成功");
	}
	//取得指定的员工
	@GetMapping("/get")
	public EmployeeModel getById(String id) throws Exception{
		return employeeService.getByIdWithDepartmentAndRoles(id);
	}
	//取得所有的员工列表
	@GetMapping("/get/list")
	public List<EmployeeModel> getListByAll() throws Exception{
		return employeeService.getListByAllWithDepartmentWithoutRoles(); //取得关联的部门，但不取关联的角色
	}
	
	//按检索条件取得员工列表
	@GetMapping(value="/list/condition/page")
	public ResultMessage<EmployeeModel> getListByConditionWitPage(@RequestParam(required = false,defaultValue ="0") int departmentNo,@RequestParam(required = false,defaultValue ="0") int roleNo,@RequestParam(required = false,defaultValue ="") String sex,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date startJoinDate,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date endJoinDate, @RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<EmployeeModel> result=new ResultMessage<EmployeeModel>("OK","取得员工列表分页成功");
		result.setCount(employeeService.getCountByConditionWithDepartmentNoAndRolesWithPage(departmentNo, roleNo, sex, startJoinDate, endJoinDate));
		result.setPageCount(employeeService.getPageCountByConditionWithDepartmentNoAndRolesWithPage(departmentNo, roleNo, sex, startJoinDate, endJoinDate, rows));
		result.setList(employeeService.getListByConditionWithDepartmentWithoutRolesWithPage(departmentNo, roleNo, sex, startJoinDate, endJoinDate, rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	

}
