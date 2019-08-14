package com.neusoft.oa.hr.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.oa.hr.model.EmployeeModel;

/*
 * 员工的DAO层MyBatis Mapper接口
 * @Author: 吕海东
 */
@Mapper
public interface IEmployeeMapper {

	//增加，无图片
	public void insert(EmployeeModel employee) throws Exception;
	//增加，有图片
	public void insertWithPhoto(EmployeeModel employee) throws Exception;
	//修改，无图片
	public void update(EmployeeModel employee) throws Exception;
	//修改，有图片
	public void updateWithPhoto(EmployeeModel employee) throws Exception;
	//只删除员工的图片
	public void updateForDeletePhoto(EmployeeModel employee) throws Exception;
	//删除
	public void delete(EmployeeModel employee) throws Exception;
	//取得员工单个对象，同时取得关联的部门对象和关联的角色集合
	public EmployeeModel selectByIdWithDepartmentAndRoles(String id) throws Exception;
	//取得所有员工列表，不取关联的部门对象，不取关联的爱好集合,不分页
	public List<EmployeeModel> selectListByAllWithoutDepartmentAndRoles() throws Exception;
	//取得所有员工列表，不取关联的部门对象，不取关联的爱好集合,分页模式
	public List<EmployeeModel> selectListByAllWithoutDepartmentAndRolesWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得所有员工列表，同时取关联的部门对象，不取关联的爱好集合
	public List<EmployeeModel> selectListByAllWithDepartmentWithoutRoles() throws Exception;
	//根据综合检索条件取得员工列表，取得关联的部门，不取关联的爱好列表，分页模式
	public List<EmployeeModel> selectListByConditionWithDepartmentNoAndRolesWithPage(@Param("departmentNo") int departmentNo,@Param("roleNo") int roleNo,@Param("sex") String sex,@Param("startJoinDate") Date startJoinDate,@Param("endJoinDate") Date endJoinDate, @Param("start") int start,@Param("rows") int rows) throws Exception;
	//根据综合检索条件取得员工个数
	public int selectCountByCondition(@Param("departmentNo") int departmentNo,@Param("roleNo") int roleNo,@Param("sex") String sex,@Param("startJoinDate") Date startJoinDate,@Param("endJoinDate") Date endJoinDate) throws Exception;
	//为员工增加爱好
	public void addRoles(@Param("id") String id,@Param("Roles") int[] Roles) throws Exception;
	//删除指定员工的所有爱好
	public void deleteRoles(String id) throws Exception;
	//检查指定的ID的员工个数，用于验证员工ID是否存在
	public int selectCountByIdAndPassword(@Param("id") String id,@Param("password") String password) throws Exception;
	
}
