package com.neusoft.oa.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.oa.hr.model.RoleModel;
/*
 * 员工角色的DAO层Mapper接口
 * @Author: 吕海东
 */
@Mapper
public interface IRoleMapper {
	//增加
	public void insert(RoleModel behave) throws Exception;
	//修改
	public void update(RoleModel behave) throws Exception;
	//删除
	public void delete(RoleModel behave) throws Exception;
	//取得角色单个对象
	public RoleModel selectByNo(int no) throws Exception;
	//取得所有角色列表
	public List<RoleModel> selectListByAll() throws Exception;
	//取得所有角色列表,分页模式
	public List<RoleModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得角色的个数
	public int selectCountByAll() throws Exception;
	
}
