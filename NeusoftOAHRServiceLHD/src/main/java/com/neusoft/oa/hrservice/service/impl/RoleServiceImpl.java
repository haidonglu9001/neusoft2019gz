package com.neusoft.oa.hrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.oa.hrservice.mapper.IRoleMapper;
import com.neusoft.oa.hrservice.model.RoleModel;
import com.neusoft.oa.hrservice.service.IRoleService;

@Service
@Transactional

public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleMapper roleMapper=null;

	@Override
	public void add(RoleModel role) throws Exception {
		roleMapper.insert(role);
		
	}

	@Override
	public void modify(RoleModel role) throws Exception {
		roleMapper.update(role);
		
	}

	@Override
	public void delete(RoleModel  role) throws Exception {
		roleMapper.delete(role);
		
	}

	@Override
	public RoleModel getByNo(int no) throws Exception {
		
		return roleMapper.selectByNo(no);
	}

	@Override
	public List<RoleModel> getListByAll() throws Exception {
		
		return roleMapper.selectListByAll();
	}

	
	@Override
	public List<RoleModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return roleMapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int selectCountByAll() throws Exception {
		
		return roleMapper.selectCountByAll();
	}

}
