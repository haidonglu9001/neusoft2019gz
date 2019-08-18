package com.neusoft.oa.hrservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.oa.hrservice.mapper.IRoleMapper;
import com.neusoft.oa.hrservice.model.RoleModel;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleMapper roleMapper=null;

	@Override
	public List<RoleModel> getListByAll() throws Exception {
		
		return roleMapper.selectListByAll();
	}

}
