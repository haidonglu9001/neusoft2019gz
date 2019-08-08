package com.neusoft.busmis.security.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.neusoft.busmis.security.dao.IUserDao;

import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;


//用户的业务实现类
@Service("userService04")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao=null;
	
	@Value("${server.port}")
	private  String port=null;
	
	
	//默认的构造方法
	/*
	public UserServiceImpl() {
		System.out.println("User Service构造方法00执行。。。。");
	}
	*/
	//@Autowired
	//@Inject
	/*
	public UserServiceImpl(@Qualifier("sqlSessionFactory") SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("User Service构造方法01执行。。。。");
	}
	*/
	//有依赖对象参数的构造方法
	//@Autowired
	
	/*
	 * public UserServiceImpl(SqlSessionFactory sessionFactory,int age,String name)
	 * { this.sessionFactory = sessionFactory; this.age = age; this.name = name;
	 * System.out.println("User Service构造方法02执行。。。。"); }
	 */
	
	

	@Override
	public void register(UserModel userModel) throws Exception {
		if(userModel.getPhotoFileName()!=null) {
			userDao.createWithPhoto(userModel);
		}
		else {
			userDao.create(userModel);
		}
		
		
	
	}
	@Override
	public void modify(UserModel userModel) throws Exception {
		
		userDao.update(userModel);
		
	}
	@Override
	public void changePasswowrd(String id, String password) throws Exception {
		
	}
	@Override
	public void changrRole(String id, String role) throws Exception {
	}
	@Override
	public boolean validate(String id, String password) throws Exception {
		boolean result=false;
		
		UserModel um=userDao.selectById(id);
		if(um!=null&&um.getPassword()!=null&&um.getPassword().equals(password)) {
			result=true;
		}
		
		return result;
	}
	@Override
	public void active(String id) throws Exception {
		
	}
	@Override
	public void disable(String id) throws Exception {
		
	}
	@Override
	public void delete(UserModel userModel) throws Exception {
	
		//调用DAO接口的方法
		userDao.delete(userModel);
	
	}
	@Override
	public List<UserModel> getListByAll() throws Exception {
		
		//调用DAO接口的方法
		List<UserModel> list=userDao.selectListByAll();
		System.out.println("服务启动端口："+port);
		
		
		return list;
	}
	@Override
	public UserModel getById(String id) throws Exception {
		
		return userDao.selectById(id);
	}
	//rows：每屏显示的个数， page:页号
	@Override
	public List<UserModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return userDao.selectListByAllWithPage(rows*(page-1), rows);
	}
	@Override
	public void addRoles(String userId, int[] roleNos) throws Exception {
				
		
		userDao.deleteRoles(userId);
		//再增加新的角色
		userDao.addRoles(userId, roleNos);
	
		
	}
	@Override
	public List<ModuleModel> getModuleListByUser(String userid) throws Exception {
		return userDao.selectModuleListByUser(userid);
	}
	@Override
	public List<UserModel> getListByCondition(int roleNo, String keyName, int minAge, int maxAge, Date startDate,
			Date endDate) throws Exception {
		
		if(keyName!=null&&keyName.trim().length()>0) {
			keyName="%"+keyName+"%";
		}
	
		return userDao.selectListByCondition(roleNo, keyName, minAge, maxAge, startDate, endDate);
	}

}
