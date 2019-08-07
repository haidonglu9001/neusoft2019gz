package com.neusoft.busmis.security.service;

import java.util.List;

import com.neusoft.busmis.security.model.FunctionModel;

//系统功能业务接口
public interface IFunctionService {
	
	public void create(FunctionModel function) throws Exception;
	public void update(FunctionModel function) throws Exception;
	public void delete(FunctionModel function) throws Exception;
	//取得所有系统功能列表
	public List<FunctionModel> selectListByAll() throws Exception;
	public List<FunctionModel> selectListByAllWithModuleByNestedSelect() throws Exception;
	public List<FunctionModel> selectListByAllWithModuleByNestedResultMap() throws Exception;
	
	//取得指定模块系统功能列表,参数:moduleNo 模块编号
	public List<FunctionModel> selectListByModule(int moduleNo) throws Exception;
	//取得指定的系统功能对象
	public FunctionModel selectByNo(int no) throws Exception;
	//取得所有功能的个数
	public int selectCountByAll() throws Exception;
	//取得指定模块的功能的个数,参数:moduleNo 模块编号
	public int selectCountByModule(int moduleNo) throws Exception;

	
	
}
