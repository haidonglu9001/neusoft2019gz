package com.neusoft.ribbon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neusoft.ribbon.message.ResultMessage;
import com.neusoft.ribbon.model.RoleModel;
import com.neusoft.ribbon.service.IRoleService;
//服务调用者测试业务层
@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private RestTemplate rest=null;

	//增加Hystrix断路器注解
	@HystrixCommand(fallbackMethod ="getListError" )
	@Override
	public ResultMessage<RoleModel> getList() throws Exception {
		List<RoleModel> list=rest.getForObject("http://neusofthrservicelhd/role/list/all", List.class);
		ResultMessage<RoleModel> result=new ResultMessage<RoleModel>("OK","取得角色列表成功");
		result.setList(list);
		return result;
	}
	
	public ResultMessage<RoleModel> getListError() throws Exception {
		
		return new ResultMessage<RoleModel>("ERROE","取得角色列表失败");
	}
	
	
	

}
