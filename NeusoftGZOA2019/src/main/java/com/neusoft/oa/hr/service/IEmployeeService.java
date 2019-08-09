package com.neusoft.oa.hr.service;

import java.util.Date;
import java.util.List;
import com.neusoft.oa.hr.model.EmployeeModel;

/*
 * 员工部门业务层接口
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
	//取得员工单个对象，同时取得关联的部门对象和关联的爱好集合
	public EmployeeModel getByIdWithDepartmentAndBehaves(String id) throws Exception;
	//取得所有员工列表，不取关联的部门对象，不取关联的爱好集合,不分页
	public List<EmployeeModel> getListByAllWithoutDepartmentAndBehaves() throws Exception;
	//取得所有员工列表，不取关联的部门对象，不取关联的爱好集合,分页模式
	public List<EmployeeModel> getListByAllWithoutDepartmentAndBehavesWithPage(int rows,int page) throws Exception;
	//取得所有员工列表，同时取关联的部门对象，不取关联的爱好集合
	public List<EmployeeModel> getListByAllWithDepartmentWithoutBehaves() throws Exception;
	//根据综合检索条件取得员工列表，取得关联的部门，不取关联的爱好列表，分页模式
	public List<EmployeeModel> getListByConditionWithDepartmentNoAndBehavesWithPage(int departmentNo,int behaveNo,String sex,Date startJoinDate,Date endJoinDate,int start,int rows) throws Exception;
	//根据综合检索条件取得员工个数
	public List<EmployeeModel> getCountByConditionWithDepartmentNoAndBehavesWithPage(int departmentNo,int behaveNo,String sex,Date startJoinDate,Date endJoinDate) throws Exception;
	//为员工增加爱好
	public void addBehaves(String id,int[] behaves) throws Exception;
	//删除指定员工的所有爱好
	public void deleteBehaves(String id) throws Exception;
}
