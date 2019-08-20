package com.neusoft.ribbon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.neusoft.ribbon.model.RoleModel;
import com.neusoft.ribbon.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private RestTemplate rest=null;

	@Override
	public List<RoleModel> getList() throws Exception {
		
		List<RoleModel> list=rest.getForObject("http://neusofthrservicelhd/role/list/all", List.class);
		return list;
	}

}
