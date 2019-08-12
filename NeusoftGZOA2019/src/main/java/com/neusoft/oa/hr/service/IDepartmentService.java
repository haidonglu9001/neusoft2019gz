package com.neusoft.oa.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.oa.hr.model.DepartmentModel;

/*
 * 部门业务层接口
 * @Author: 吕海东
 */
public interface IDepartmentService {
	//增加
	public void add(DepartmentModel department) throws Exception;
	//修改
	public void modify(DepartmentModel department) throws Exception;
	//删除
	public void delete(DepartmentModel department) throws Exception;
	//取得部门单个对象，同时取得关联的员工列表
	public DepartmentModel getByNo(int no) throws Exception;
	//取得所有部门列表，不取关联的员工列表
	public List<DepartmentModel> getListByAll() throws Exception;
	
	//取得所有部门列表,分页模式，不取关联的员工列表
	public List<DepartmentModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得部门的个数
	public int getCountByAll() throws Exception;
	//取得部门页数
	public int getPagaCountByAll(int rows) throws Exception;
	//检查部门能否被删除
	public boolean checkCanDelete(int no) throws Exception;
	

}
