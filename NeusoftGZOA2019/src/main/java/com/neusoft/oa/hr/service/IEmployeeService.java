package com.neusoft.oa.hr.service;

import java.util.Date;
import java.util.List;
import com.neusoft.oa.hr.model.EmployeeModel;

/*
 * 模块：人力资源HR
 * 员工部门业务接口
 * @Author: 吕海东
 */
public interface IEmployeeService {

	//增加，无图片
	public void add(EmployeeModel employee) throws Exception;
	//增加，有图片
	public void addWithPhoto(EmployeeModel employee) throws Exception;
	//修改，无图片
	public void modify(EmployeeModel employee) throws Exception;
	//修改，有图片
	public void modifyWithPhoto(EmployeeModel employee) throws Exception;
	//只删除员工的图片
	public void modifyForDeletePhoto(EmployeeModel employee) throws Exception;
	//删除
	public void delete(EmployeeModel employee) throws Exception;
	//取得员工单个对象，同时取得关联的部门对象和关联的角色集合
	public EmployeeModel getByIdWithDepartmentAndRoles(String id) throws Exception;
	//取得所有员工列表，不取关联的部门对象，不取关联的角色集合,不分页
	public List<EmployeeModel> getListByAllWithoutDepartmentAndRoles() throws Exception;
	//取得所有员工列表，不取关联的部门对象，不取关联的角色集合,分页模式
	public List<EmployeeModel> getListByAllWithoutDepartmentAndRolesWithPage(int rows,int page) throws Exception;
	//取得所有员工列表，同时取关联的部门对象，不取关联的角色集合
	public List<EmployeeModel> getListByAllWithDepartmentWithoutRoles() throws Exception;
	//根据综合检索条件取得员工列表，取得关联的部门，不取关联的角色列表，分页模式
	public List<EmployeeModel> getListByConditionWithDepartmentWithoutRolesWithPage(int departmentNo,int roleNo,String sex,Date startJoinDate,Date endJoinDate,int rows,int page) throws Exception;
	//根据综合检索条件取得员工个数
	public int getCountByConditionWithDepartmentNoAndRolesWithPage(int departmentNo,int roleNo,String sex,Date startJoinDate,Date endJoinDate) throws Exception;
	//根据综合检索条件取得员工显示的页数
	public int getPageCountByConditionWithDepartmentNoAndRolesWithPage(int departmentNo,int roleNo,String sex,Date startJoinDate,Date endJoinDate,int rows) throws Exception;
	//为员工增加角色
	public void addRoles(String id,int[] Roles) throws Exception;
	//删除指定员工的所有角色
	public void deleteRoles(String id) throws Exception;
	//验证员工ID是否存在
	public  boolean checkIdExist(String id) throws Exception;
	//验证员工是否合法
	public boolean checkValidate(String id,String password) throws Exception;
}
