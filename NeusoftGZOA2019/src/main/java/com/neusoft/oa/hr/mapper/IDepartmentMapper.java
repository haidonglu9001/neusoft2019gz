package com.neusoft.oa.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.oa.hr.model.DepartmentModel;

/*
 * 部门的DAO层MyBatis Mapper接口
 * @Author: 吕海东
 */
@Mapper
public interface IDepartmentMapper {

	//增加
	public void insert(DepartmentModel department) throws Exception;
	//修改
	public void update(DepartmentModel department) throws Exception;
	//删除
	public void delete(DepartmentModel department) throws Exception;
	//取得部门单个对象，同时取得关联的员工列表
	public DepartmentModel selectByNo(int no) throws Exception;
	//取得所有部门列表，不取关联的员工列表
	public List<DepartmentModel> selectListByAll() throws Exception;
	
	//取得所有部门列表,分页模式，不取关联的员工列表
	public List<DepartmentModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得部门的个数
	public int selectCountByAll() throws Exception;
		
}
