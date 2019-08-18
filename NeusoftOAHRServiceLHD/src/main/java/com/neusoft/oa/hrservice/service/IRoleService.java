package com.neusoft.oa.hrservice.service;

import java.util.List;

import com.neusoft.oa.hrservice.model.RoleModel;

public interface IRoleService {
	
	public List<RoleModel> getListByAll() throws Exception;

}
