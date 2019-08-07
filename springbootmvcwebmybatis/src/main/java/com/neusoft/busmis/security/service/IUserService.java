package com.neusoft.busmis.security.service;

import java.util.Date;
import java.util.List;

import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;

//用户的业务接口
public interface IUserService {
	//注册用户
	public void register(UserModel userModel) throws Exception;
	//修改用户
	public void modify(UserModel userModel) throws Exception;
	//修改密码
	public void changePasswowrd(String id, String password) throws Exception;
	//修改角色
	public void changrRole(String id, String role) throws Exception;
	//验证用户合法性
	public boolean validate(String id, String password) throws Exception;
	//激活用户，可以登录
	public void active(String id) throws Exception;
	//终止用户，此用户不能登录
	public void disable(String id) throws Exception;
	//删除用户
	public void delete(UserModel userModel) throws Exception;
	
	//取得所有用户列表
	//R方法-查询  取得列表
	public List<UserModel> getListByAll() throws Exception;
	
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception;
	
	//R方法-查询  查询返回单个对象，一般根据表的主键字段值获取
	public UserModel getById(String id) throws Exception;
	
	//为用户增加角色(每次增加多个）
	public void addRoles(String userId, int[] roleNos) throws Exception;
	//取得指定用户的被授予的模块列表
	public List<ModuleModel> getModuleListByUser(String userid) throws Exception;
	//按综合条件检索用户列表
	public List<UserModel> getListByCondition(int roleNo,String keyName,int minAge,int maxAge,Date startDate,Date endDate) throws Exception;
	
	
	

}
