package com.neusoft.busmis.security.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.RoleModel;
import com.neusoft.busmis.security.model.UserModel;

//用户的DAO层接口
@Mapper
public interface IUserDao {
	//C方法-增加
	public void create(UserModel userModel) throws Exception; //无图片
	public void createWithPhoto(UserModel userModel) throws Exception; //有图片
	
	public void createWithParam(String id,String password,String name,int age) throws Exception;
	//U方法-修改
	public void update(UserModel userModel) throws Exception;
	//D方法-删除
	public void delete(UserModel userModel) throws Exception;
	//R方法-查询  取得列表. 只取得用户的信息，不取得用户关联的角色列表
	public List<UserModel> selectListByAll() throws Exception;
	//R方法-查询  取得列表. 只取得用户的信息，不取得用户关联的角色列表
	public List<UserModel> selectListByAllWithRoles() throws Exception;
	
	//R方法-查询  取得列表,有分页, start: 起始的记录号， rows: 取得个数
	public List<UserModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//R方法-查询  查询返回单个对象，一般根据表的主键字段值获取
	public UserModel selectById(String id) throws Exception;
	
	//为用户增加角色
	//每次增加一个角色
	public void addRole(@Param("id") String id, @Param("roleNo") int roleNo) throws Exception;
	//每次增加多个角色
	public void addRoles(@Param("id") String id, @Param("roleNoList")  int[] roleNoList) throws Exception;
	//删除指定用户的所有角色
	public void deleteRoles(String id) throws Exception;
	
	//取得指定用户的角色列表
	public List<RoleModel> selectRoleListByUser(String userid) throws Exception;
	//判断指定的用户是否有指定的角色,取得用户和角色关联的个数
	public int selectCountByUserAndRoles(@Param("id") String id, @Param("roleNo") int roleNo) throws Exception;
	//取得指定用户授予的模块列表
	public List<ModuleModel> selectModuleListByUser(String userid) throws Exception;
	//按检索条件取得用的列表:按照给定的参数检索用户列表：
	//int类型参数如果是0，不考虑此参数； 其他类型如果是空 ，空串或Null，则不考虑此删除
	public List<UserModel> selectListByCondition(@Param("roleNo") int roleNo,@Param("key") String keyName,@Param("min") int minAge,@Param("max") int maxAge,@Param("start") Date startDate,@Param("end") Date endDate) throws Exception;
	
	
	
	
}
