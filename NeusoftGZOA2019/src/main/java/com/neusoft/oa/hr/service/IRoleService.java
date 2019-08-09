package com.neusoft.oa.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.oa.hr.model.RoleModel;

/*
 * 角色业务层接口
 * @Author: 吕海东
 */
public interface IRoleService {

	//增加
	public void add(RoleModel role) throws Exception;
	//修改
	public void modify(RoleModel role) throws Exception;
	//删除
	public void delete(RoleModel role) throws Exception;
	//取得角色单个对象
	public RoleModel getByNo(int no) throws Exception;
	//取得所有角色列表
	public List<RoleModel> getListByAll() throws Exception;
	//取得所有角色列表,分页模式
	public List<RoleModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得角色的个数
	public int getCountByAll() throws Exception;
	//取得角色页数
	public int getPagaCountByAll(int rows) throws Exception;
}
