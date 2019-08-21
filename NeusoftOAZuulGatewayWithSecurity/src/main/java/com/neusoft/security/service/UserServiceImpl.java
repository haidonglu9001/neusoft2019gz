package com.neusoft.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.security.mapper.IUserMapper;
import com.neusoft.security.model.JwtUser;
import com.neusoft.security.model.UserModel;
@Service("UserService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper usermpper=null;

	@Override
	public void add(UserModel um) throws Exception {
		usermpper.create(um);

	}

	@Override
	public UserModel getByUserName(String username) throws Exception {
		
		return usermpper.selectByUserName(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel um;
		try {
			um = usermpper.selectByUserName(username);
			System.out.println(um.getUsername());
			System.out.println(um.getPassword());
			System.out.println(um.getRole());
			um.setUsername(username);
			return new JwtUser(um);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
