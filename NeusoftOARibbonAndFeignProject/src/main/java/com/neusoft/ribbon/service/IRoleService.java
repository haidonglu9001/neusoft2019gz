package com.neusoft.ribbon.service;

import java.util.List;

import com.neusoft.ribbon.message.ResultMessage;
import com.neusoft.ribbon.model.RoleModel;
//角色的业务接口
public interface IRoleService {
	
	public  ResultMessage<RoleModel> getList() throws Exception;
	
	

}
