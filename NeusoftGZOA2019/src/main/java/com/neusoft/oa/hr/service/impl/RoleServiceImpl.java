package com.neusoft.oa.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.oa.hr.mapper.IRoleMapper;
import com.neusoft.oa.hr.model.RoleModel;
import com.neusoft.oa.hr.service.IRoleService;
/*
 * 模块：HR 人力资源
 * 角色业务层接口的实现类
 * @Author: 吕海东
 */
@Service
@Transactional(rollbackFor = Exception.class)
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
	public void delete(RoleModel role) throws Exception {
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
	public int getCountByAll() throws Exception {
		
		return roleMapper.selectCountByAll();
	}

	@Override
	public int getPagaCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

}
